# MultipleFileUpload Parity Map (draft)
## Scope
- Legacy JSP: `src/main/webapp/jsp/MultipleFileUpload.jsp`.
- Legacy Struts action mappings:
- `/MultipleFileUpload` → `net.sam.dcl.controller.actions.HibernateAction`

## Form beans
- `MultipleFileUpload` → `net.sam.dcl.action.MultipleFileUploadActionBean`.

## SQL/DAO inventory
- Candidate DAO classes: `TBD`
- Candidate SQL resource IDs: `TBD`

## Fields mapping
| Legacy property | New DTO/Entity | Type | Validation | Readonly cond | Notes |
|-----------------|----------------|------|------------|---------------|-------|
| TBD | TBD | TBD | TBD | TBD | Fill during implementation |

## Actions
| Dispatch/Button | New endpoint | Params | Response |
|-----------------|-------------|--------|----------|
| `dispatch` | `TBD` | `TBD` | `TBD` |

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
