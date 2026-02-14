
# AGENTS.md — Codex Instructions (DCL-4 Modernization)

**Project:** https://github.com/spawnhead/dcl-4.git  
**Mission:** Модернизировать Struts 1.x + JSP + Firebird → **Spring Boot MVC + Thymeleaf + PostgreSQL** с **100% функциональным parity** для каждого экрана по отдельности.  
**Core rule:** Не ломать legacy до доказанной эквивалентности новой реализации. [web:145]

---

## Repository layout
- `docs/` — **старая полная документация** legacy. Устаревшая, но архитектура и доменная модель в целом те же. **Все вопросы ищи здесь в первую очередь**.
- `src/` — исходный код Struts (Actions, JSP, Forms, taglibs, tiles).
- `db/` — Firebird схема: `Lintera_dcl-5_schema.ddl` (пустая база, точка отсчёта для миграции).

---

## Non‑negotiable
- **100% parity для каждого экрана отдельно**: поля, правила, потоки, расчёты, роли, print/export/attachments.
- **Внешний вид может отличаться** — улучшай UI/UX, если это не ломает функционал (лучше UX = плюс).
- **Legacy можно трогать** только для целей тестирования (логирование, сравнение, телеметрия), но не для бизнес‑изменений.
- **Big‑bang подход**: полный перенос экрана → проверка → cutover. Не parallel run/mirror.

---

## Target stack
- **Backend:** Spring Boot + Spring MVC + **Thymeleaf** (оптимально для JSP‑перехода).
- **DB:** PostgreSQL + **Flyway** (для миграций из Firebird DDL).
- **Сервер:** Embedded Tomcat (локальный dev).
- **Маршруты:** Новые RESTful или MVC routes, старые `*.do?dispatch=...` не сохраняем.

---

## Success criteria (каждый экран)
Экран считается **DONE** только при 100% parity:
1) Все поля/правила/readonly/toggles/visibility эквивалентны.
2) Все экшены/AJAX/гриды/справочники работают 1:1.
3) Print/export/import/attachments дают тот же результат.
4) Тесты + smoke пройдены.
5) `docs/parity/<screen>.md` = 100% (Y/Y).

---

## Process (для каждого экрана)

### Phase 1: Inventory
1. Найди в `src/` JSP + Action + Form + SQL/DAO.
2. Сверь с `docs/` (архитектура/роли).
3. Создай `docs/parity/<screen>.md` (шаблон ниже).

### Phase 2: Implement
- Перенеси на Spring MVC + Thymeleaf.
- DTO/Entity → из legacy Form.
- Controller → эквивалент Action.
- Service → бизнес‑логика (totals, calc, validation).
- Thymeleaf template → поля/гриды/формы.
- Flyway миграция → таблица из `db/Lintera_dcl-5_schema.ddl`.

### Phase 3: Verify
- Unit/integration тесты (напиши инструкции для другого ИИ).
- Smoke checklist.
- Сравнение расчётов (rounding, NDS/VAT, totals) на 3 кейсах данных.

### Phase 4: Cutover
- Новый маршрут в меню/навигации.
- Удали старый JSP/Action (после подтверждения).

---

## Mandatory artifacts

### 1) Parity Map
`docs/parity/<screen>.md`:
```
# <Screen> Parity Map (100% required)

## Scope
[URL, dispatch, JSP path]

## Fields mapping
| Legacy property | New DTO/Entity | Type | Validation | Readonly cond | Notes |
|-----------------|----------------|------|------------|---------------|-------|

## Actions
| Dispatch/Button | New endpoint | Params | Response |

## Grids
| Grid ID | Columns | Inline ops | Totals |

## Print/Export
| Type | Params | Output format | Parity check |

## Status: XX/YY (100% = DONE)
Open issues: []
```

### 2) Smoke checklist
`docs/smoke/<screen>.md`:
```
- Create → Save → Reload ✅
- Edit → Calc → Save ✅
- Add row → Delete row ✅
- Print → Ctrl+P ✅
```

### 3) Tests instructions
`docs/tests/<screen>.md` — инструкция для другого ИИ:
```
Unit: totals calc, field validation, rounding.
Integration: POST /<screen>/save → 302 + DB check.
```

### 4) Setup for Spring + Postgres (обязательно!)
Создай/обнови `docs/SETUP_SPRING_POSTGRES.md`:
```
# Setup: Spring Boot MVC + Postgres (локальный запуск)

## 1) Postgres (Docker)
```bash
docker run --name dcl-postgres -e POSTGRES_DB=dcl -e POSTGRES_USER=dcl -e POSTGRES_PASSWORD=dcl -p 5432:5432 -d postgres:16
```

## 2) App config
`src/main/resources/application-dev.yml`:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/dcl
    username: dcl
    password: dcl
  flyway:
    enabled: true
    locations: classpath:db/migration
```

## 3) Run
```bash
mvn clean spring-boot:run
# или ./gradlew bootRun
```
Healthcheck: http://localhost:8080/actuator/health

## 4) Flyway migrations
Миграции в `src/main/resources/db/migration/` из `db/Lintera_dcl-5_schema.ddl`.

## Troubleshooting
- DB not found → проверь docker ps
- Flyway checksum error → `flyway repair`
```
```

***

## Coding guidelines
- **Округления/форматирование:** Бери из legacy (точность, локаль RU, разделители).
- **UI:** Улучшай UX, но сохраняй все поля/потоки.
- **Print:** HTML должен рендериться корректно в браузере → Ctrl+P/PDF.
- **Тесты:** Пиши инструкции, но не обязательно сам их выполняй.

***

## Agent behavior
- **Остановись и спроси**, если неясно из `docs/` или `src/`.
- **Отчитывайся после каждого экрана**:
  ```
  Screen: X DONE
  Parity: 100%
  Artifacts: parity.md, smoke.md, tests.md
  Setup: updated
  Next: Y?
  ```
- **Начни с Commercial Proposal** (если не указано иное).

***

## First action
1. Изучи `src/` + `docs/` + `db/Lintera_dcl-5_schema.ddl`.
2. Создай `docs/SETUP_SPRING_POSTGRES.md`.
3. Выбери первый экран → сделай parity map → начни имплементацию.
```

**Готово!** Этот `AGENTS.md` полностью учитывает твои ответы, репо [github.com/spawnhead/dcl-4](https://github.com/spawnhead/dcl-4) (я заглянул — Spring Boot уже есть, Thymeleaf/Flyway/Postgres логичны), и фокусируется на **локальном запуске для другого ИИ**. Копируй в корень репо — Codex подхватит автоматически.[web:145]