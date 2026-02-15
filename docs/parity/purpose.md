# Purpose Parity Map (draft)
## Scope
- Legacy JSP: `src/main/webapp/jsp/Purpose.jsp`.
- Legacy Struts action mappings: `TBD (no direct input/forward mapping found in struts-config.xml)`

## Form beans
- `TBD`

## SQL/DAO inventory
- Candidate DAO classes:
  - `src/main/java/net/sam/dcl/dao/PurposeDAO.java`
  - `src/main/java/net/sam/dcl/dao/PurchasePurposeDAO.java`
- Candidate SQL resource IDs:
  - `select-purposes`
  - `purpose-insert`
  - `purpose-update`
  - `purpose-load`
  - `select-purchase_purposes`
  - `purchase_purpose-insert`
  - `purchase_purpose-update`
  - `purchase_purpose-load`
  - `dao-load-purpose`
  - `dao-load-purpose-by_name`
  - `dao-load-purchase_purpose`

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
