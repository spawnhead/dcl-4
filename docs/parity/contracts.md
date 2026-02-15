# Contracts Parity Map (draft)
## Scope
- Legacy JSP: `src/main/webapp/jsp/Contracts.jsp`.
- Legacy Struts action mappings: `TBD (no direct input/forward mapping found in struts-config.xml)`

## Form beans
- `TBD`

## SQL/DAO inventory
- Candidate DAO classes: `TBD`
- Candidate SQL resource IDs:
  - `select-contracts`
  - `select-contracts-for-contractor-id`
  - `select-contracts-for-contractor-id-for_cc`
  - `select-contracts_closed`
  - `select-contracts_closed_new-dao`
  - `select-contracts_closed-dao`
  - `select-contractors-for_contracts_closed-filter`

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
