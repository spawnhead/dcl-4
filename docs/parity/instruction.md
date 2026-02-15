# Instruction Parity Map (draft)
## Scope
- Legacy JSP: `src/main/webapp/jsp/Instruction.jsp`.
- Legacy Struts action mappings: `TBD (no direct input/forward mapping found in struts-config.xml)`

## Form beans
- `TBD`

## SQL/DAO inventory
- Candidate DAO classes:
  - `src/main/java/net/sam/dcl/dao/InstructionTypeDAO.java`
  - `src/main/java/net/sam/dcl/dao/InstructionDAO.java`
- Candidate SQL resource IDs:
  - `select-instructions`
  - `instruction-insert`
  - `instruction-load`
  - `instruction-update`
  - `select-instruction_types`
  - `instruction_type-insert`
  - `instruction_type-update`
  - `instruction_type-load`

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
