# Language Parity Map (draft)
## Scope
- Legacy JSP: `src/main/webapp/jsp/Language.jsp`.
- Legacy Struts action mappings: `TBD (no direct input/forward mapping found in struts-config.xml)`

## Form beans
- `TBD`

## SQL/DAO inventory
- Candidate DAO classes:
  - `src/main/java/net/sam/dcl/dao/LanguageDAO.java`
- Candidate SQL resource IDs:
  - `select-user-languages`
  - `insert_user_language`
  - `update_user_language`
  - `select-unit-languages`
  - `insert_unit_language`
  - `update_unit_language`
  - `select-languages`
  - `language-insert`
  - `language-update`
  - `language-load`
  - `select-user_language-dao`
  - `dao-load-language`
  - `dao-load-language_by_tetter_id`

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
