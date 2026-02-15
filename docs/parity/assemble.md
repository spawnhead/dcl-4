# Assemble Parity Map (draft)
## Scope
- Legacy JSP: `src/main/webapp/jsp/Assemble.jsp`.
- Legacy Struts action mappings: `TBD (no direct input/forward mapping found in struts-config.xml)`

## Form beans
- `TBD`

## SQL/DAO inventory
- Candidate DAO classes:
  - `src/main/java/net/sam/dcl/dao/AssembleProduceDAO.java`
  - `src/main/java/net/sam/dcl/dao/AssembleDAO.java`
- Candidate SQL resource IDs:
  - `assemble-positions-available-for-delivery-request`
  - `select-assembles`
  - `assembles-load`
  - `assemble-insert`
  - `assemble-update`
  - `assemble-load`
  - `assemble-load_by_apr_id`
  - `select-assemble_produces`
  - `assemble_produce-load`
  - `insert_assemble_produce`
  - `update_assemble_produce`
  - `delete_assemble_produces`
  - `order-positions-available-for-assemble`
  - `assemble-positions-available-for-produce-cost`
  - `get-num_assemble`

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
