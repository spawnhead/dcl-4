# Action Parity Map (draft)
## Scope
- Legacy JSP: `src/main/webapp/jsp/Action.jsp`.
- Legacy Struts action mappings: `TBD (no direct input/forward mapping found in struts-config.xml)`

## Form beans
- `TBD`

## SQL/DAO inventory
- Candidate DAO classes:
  - `src/main/java/net/sam/dcl/dao/ActionDAO.java`
- Candidate SQL resource IDs:
  - `select-user-actions`
  - `select-actions`
  - `action-load`
  - `action-update`
  - `select-actions_in_list`
  - `select-action-roles-out`
  - `select-action-roles-in`
  - `add-action-roles`
  - `delete-action-roles`
  - `add-action-roles-all`
  - `delete-action-roles-all`
  - `log-insert_by_action_system_name`

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
