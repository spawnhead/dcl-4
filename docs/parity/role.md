# Role Parity Map (draft)
## Scope
- Legacy JSP: `src/main/webapp/jsp/Role.jsp`.
- Legacy Struts action mappings: `TBD (no direct input/forward mapping found in struts-config.xml)`

## Form beans
- `TBD`

## SQL/DAO inventory
- Candidate DAO classes:
  - `src/main/java/net/sam/dcl/dao/RoleDAO.java`
- Candidate SQL resource IDs:
  - `select-roles`
  - `role-load`
  - `role-insert`
  - `role-update`
  - `select-user-roles-out`
  - `select-user-roles-in`
  - `test-select-user-roles-out`
  - `test-select-user-roles-in`
  - `select-user-roles`
  - `add-user-roles`
  - `delete-user-roles`
  - `delete-roles-for-user`
  - `add-user-roles-all`
  - `delete-user-roles-all`
  - `select-action-roles-out`
  - `select-action-roles-in`
  - `add-action-roles`
  - `delete-action-roles`
  - `add-action-roles-all`
  - `delete-action-roles-all`

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
