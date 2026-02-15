# Specification Parity Map (draft)
## Scope
- Legacy JSP: `src/main/webapp/jsp/Specification.jsp`.
- Legacy Struts action mappings: `TBD (no direct input/forward mapping found in struts-config.xml)`

## Form beans
- `TBD`

## SQL/DAO inventory
- Candidate DAO classes:
  - `src/main/java/net/sam/dcl/dao/SpecificationImportProduceDAO.java`
  - `src/main/java/net/sam/dcl/dao/SpecificationImportDAO.java`
  - `src/main/java/net/sam/dcl/dao/SpecificationDAO.java`
- Candidate SQL resource IDs:
  - `select-cfc_specifications_numbers-for-contract-id`
  - `select-specifications`
  - `select-specifications-for-contract-id`
  - `select-specifications-for-contract-id-include-exec`
  - `select-specifications_numbers-for-contract-id`
  - `specification-load`
  - `specification-load-comment`
  - `specification-load-for-payment`
  - `specification-insert`
  - `specification-update`
  - `delete_specifications`
  - `select-specification_payments`
  - `delete_specification_payments`
  - `insert_specification_payment`
  - `specification-import-available-for-delivery-request`
  - `select-specification_imports`
  - `specification_import-insert`
  - `specification_import-update`
  - `specification_import-update-arrive`
  - `specification_import-update-send_date`

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
