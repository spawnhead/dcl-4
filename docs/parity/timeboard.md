# Timeboard Parity Map (draft)
## Scope
- Legacy JSP: `src/main/webapp/jsp/Timeboard.jsp`.
- Legacy Struts action mappings: `TBD (no direct input/forward mapping found in struts-config.xml)`

## Form beans
- `TBD`

## SQL/DAO inventory
- Candidate DAO classes:
  - `src/main/java/net/sam/dcl/dao/TimeboardDAO.java`
- Candidate SQL resource IDs:
  - `select-timeboards`
  - `timeboard-insert`
  - `timeboard-update`
  - `timeboard-update-checked`
  - `timeboard-load`
  - `timeboard-load-by_usr_id_tmb_date`
  - `select-timeboard_works`
  - `delete_timeboard_works`
  - `insert_timeboard_work`

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
