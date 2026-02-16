# Cutover Plan (AGENTS.md)

План перехода на modern stack: staging → миграция данных → production. Детали по переключению кода (src → src_modern) см. в [Docs/CUTOVER.md](Docs/CUTOVER.md).

## Phase 1: Staging

Поднять окружение и проверить parity вручную:

```bash
docker compose -f docker-compose.test.yml up
```

После старта приложения (Flyway выполнится при первом запуске) — ручная проверка экранов на parity с legacy.

## Phase 2: Data Migration

Миграция данных Firebird → Postgres:

```bash
./scripts/full_migrate.sh
```

(Требуется настроенный доступ к Firebird и переменные/конфиг скрипта.)

## Phase 3: Production Deploy

Запуск production-стека (postgres + flyway + app из `docker-compose.prod.yml`):

```bash
docker compose -f docker-compose.prod.yml up -d
```

Проверка:

```bash
curl -f http://localhost:8080/actuator/health
```

Для prod нужен собранный JAR в `./build/app.jar` (либо доработать compose под образ из Dockerfile).

## Rollback

Остановка и откат:

```bash
docker compose -f docker-compose.prod.yml down
# при необходимости восстановление legacy:
# git checkout src/
# перезапуск старого стека
```
