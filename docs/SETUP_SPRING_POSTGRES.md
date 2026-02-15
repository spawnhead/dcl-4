# Setup: Spring Boot MVC + Postgres (локальный запуск)

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
Создайте профиль `dev` в `src/main/resources/application-dev.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/dcl
    username: dcl
    password: dcl
  flyway:
    enabled: true
    locations: classpath:db/migration
management:
  endpoints:
    web:
      exposure:
        include: health,info
```

## 4) Compile
```bash
mvn compile
```

## 5) Run
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

## 6) Healthcheck
```bash
curl -s http://localhost:8080/actuator/health
```
Ожидаемый ответ: `{"status":"UP"}`

## 7) Flyway migrations
- Миграции хранятся в `src/main/resources/db/migration/`.
- Базовая миграция по Commercial Proposal: `V001__CommercialProposal_tables.sql`.
- Источник структуры: `db/Lintera_dcl-5_schema.ddl`.

## Troubleshooting
- `Connection refused` → проверьте, что контейнер запущен (`docker ps`).
- Ошибка логина → проверьте `POSTGRES_USER/POSTGRES_PASSWORD` и `application-dev.yml`.
- Flyway checksum mismatch → выполните `flyway repair` и повторите запуск.
