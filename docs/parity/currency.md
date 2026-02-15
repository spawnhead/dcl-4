# currency Parity Map (draft)
## Scope
- Legacy JSP: `src/main/webapp/jsp/currency.jsp`.
- Legacy Struts action mappings: `TBD (no direct input/forward mapping found in struts-config.xml)`

## Form beans
- `TBD`

## SQL/DAO inventory
- Candidate DAO classes:
  - `src/main/java/net/sam/dcl/dao/CurrencyRateDAO.java`
  - `src/main/java/net/sam/dcl/dao/CurrencyDAO.java`
- Candidate SQL resource IDs:
  - `currency-insert`
  - `currency-update`
  - `currency-load`
  - `select-currency_rates`
  - `currency_rate-insert`
  - `currency_rate-update`
  - `currency_rate-load`
  - `load-currency_rate_for_date`
  - `load-currency_rate_for_date_count`
  - `currency_rate-check`
  - `load-currency_rate_min_date`
  - `dao-load-currency`
  - `dao-load-currency-name`

## Fields mapping
| Legacy property | New DTO/Entity | Type | Validation | Readonly cond | Notes |
|-----------------|----------------|------|------------|---------------|-------|
| TBD | TBD | TBD | TBD | TBD | Fill during implementation |

## Actions
| Dispatch/Button | New endpoint | Params | Response |
|-----------------|-------------|--------|----------|
| `TBD` | `TBD` | `TBD` | `TBD` |

## Grids
| Grid ID | Columns | Inline ops | Totals |
|---------|---------|------------|--------|
| TBD | TBD | TBD | TBD |

## Print/Export
| Type | Params | Output format | Parity check |
|------|--------|---------------|--------------|
| TBD | TBD | TBD | TBD |

## Status: 0/0 (draft)
Open issues: ["Complete field-level parity extraction from JSP/Form/Action"]
