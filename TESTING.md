# TESTING.md — DCL-4 Modern Stack

## Local Quickstart (5 мин)

```bash
# Postgres (reuse или новый)
docker run -d --name dcl-modern-pg -p 5432:5432 \
  -e POSTGRES_DB=dcl -e POSTGRES_USER=dcl -e POSTGRES_PASSWORD=dcl \
  postgres:16

# Backend
mvn clean compile flyway:migrate
mvn test -Dtest=ParitySmokeTests        # smoke по экранам (Docs/parity)
mvn test -Dgroups=integration            # интеграционные тесты (Procs/DB e2e)
mvn spring-boot:run -Dspring-boot.run.profiles=modern   # localhost:8080
```

При первом запуске Flyway накатит миграции из `src_modern/resources/db/migration`. Для `flyway:migrate` используются свойства `flyway.url`, `flyway.user`, `flyway.password` (по умолчанию localhost:5432/dcl). Переопределение: `mvn flyway:migrate -Dflyway.url=jdbc:postgresql://host:5432/dcl`.

## Coverage Targets

| Тип            | Screens / тесты | Время  | Цель                    |
|----------------|-----------------|--------|-------------------------|
| Smoke          | 163/163         | ~2 мин | Render + model keys     |
| Integration    | 20/20           | ~5 мин | Procs + business logic  |
| Manual         | Top 5           | ~10 мин| UI parity vs legacy     |

- **163 экранов** — целевое число после снятия лимита в `ParitySmokeTests` (сейчас лимит 10 для быстрого прогона).
- Отчёт smoke: `src/test/resources/reports/parity-smoke-latest.md`.

## Full suite

Полный прогон всех тестов (включая Testcontainers):

```bash
mvn test
```

Только интеграционные тесты с `@Tag("integration")`:

```bash
mvn test -Dgroups=integration
```
