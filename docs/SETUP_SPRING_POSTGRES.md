# Setup: Spring Boot MVC + Postgres (локальный запуск)

Modern-ветка собрана как отдельный Maven-модуль `modern/`. Запуск только modern без legacy.

## 1) Prerequisites
- Java 17+
- Maven 3.9+
- Docker

## 2) Postgres (Docker)
```bash
docker run --name dcl-postgres \
  -e POSTGRES_DB=dcl \
  -e POSTGRES_USER=dcl \
  -e POSTGRES_PASSWORD=dcl \
  -p 5432:5432 \
  -d postgres:16
```

Проверка контейнера:
```bash
docker ps --filter "name=dcl-postgres"
```

## 3) App config
- Конфиг modern: `modern/src/main/resources/application.yml` (и профили `application-modern.yml`, `application-prod.yml`).
- Flyway: `modern/src/main/resources/db/migration/`.

## 4) Сборка и запуск (только modern)
```bash
# из корня репозитория
mvn -pl modern clean package -DskipTests
mvn -pl modern spring-boot:run -Dspring-boot.run.profiles=modern
```

Или из директории модуля:
```bash
cd modern
mvn clean package -DskipTests
mvn spring-boot:run -Dspring-boot.run.profiles=modern
```

## 5) Healthcheck и вход
```bash
curl -s http://localhost:8080/actuator/health
```
Ожидаемый ответ: `{"status":"UP"}`

Страница входа: http://localhost:8080/login  
После применения миграций (в т.ч. повторяемой `R__seed_admin_user.sql`) для проверки можно войти: **логин admin, пароль admin** (при отсутствии в БД пользователя с таким логином он создаётся автоматически).

## 6) Flyway migrations
- Миграции: `modern/src/main/resources/db/migration/` (V001–V010).
- Запуск Flyway из корня (опционально): `mvn -pl modern flyway:migrate -Dflyway.url=jdbc:postgresql://localhost:5432/dcl -Dflyway.user=dcl -Dflyway.password=dcl`

## 7) Дампы базы PostgreSQL
Файлы дампов БД для Postgres лежат в каталоге **`db/pg/`**:
- **`db/pg/dcl_database_dump.sql`** — дамп в формате SQL (plain text).
- **`db/pg/dcl_database_dump.backup`** — дамп в custom-формате (если есть).

Восстановление из SQL:
```bash
psql -h localhost -p 5432 -U dcl -d dcl -f db/pg/dcl_database_dump.sql
```

Восстановление из .backup (custom format):
```bash
pg_restore -h localhost -p 5432 -U dcl -d dcl --no-owner --no-acl db/pg/dcl_database_dump.backup
```

После восстановления дампа Flyway при старте приложения может считать миграции уже применёнными (по истории в БД); при необходимости используйте `flyway repair` или чистую БД + только миграции.

## Troubleshooting
- **Connection refused** → проверьте, что контейнер Postgres запущен (`docker ps`).
- **Ошибка логина** → проверьте `POSTGRES_USER/POSTGRES_PASSWORD` и конфиг в `modern/src/main/resources/`.
- **Flyway: checksum mismatch** → в профиле `modern` включены `flyway.out-of-order: true` и `validate-on-migrate: false`; при необходимости один раз:  
  `mvn -pl modern flyway:repair -Dflyway.url=jdbc:postgresql://localhost:5432/dcl -Dflyway.user=dcl -Dflyway.password=dcl`
- **Flyway: applied migration not resolved locally** → та же настройка позволяет стартовать; для «чистой» истории лучше поднять новую БД и применить только миграции из `db/migration/`.
- **Port 8080 already in use** → остановите процесс, занимающий порт, или запустите с другим портом:  
  `mvn -pl modern spring-boot:run -Dspring-boot.run.profiles=modern -Dspring-boot.run.jvmArguments="-Dserver.port=8081"`
- **Schema-validation: missing table** → в профиле `modern` для совместимости с существующей БД (например, после дампа) включён `spring.jpa.hibernate.ddl-auto: update`; для продакшена рекомендуется привести схему в соответствие с Flyway и перейти на `validate`.
