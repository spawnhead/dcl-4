# contractor Parity Map (draft)
## Scope
- Legacy JSP: `src/main/webapp/jsp/contractor.jsp`.
- Legacy Struts action mappings: `TBD (no direct input/forward mapping found in struts-config.xml)`

## Form beans
- `TBD`

## SQL/DAO inventory
- Candidate DAO classes:
  - `src/main/java/net/sam/dcl/dao/ContractorDAO.java`
  - `src/main/java/net/sam/dcl/dao/ContractorRequestDAO.java`
- Candidate SQL resource IDs:
  - `select-contracts-for-contractor-id`
  - `select-contracts-for-contractor-id-for_cc`
  - `select-contractor_requests`
  - `contractor_request-insert`
  - `contractor_request-update`
  - `contractor_request-load`
  - `contractor_request-load-count-for_act`
  - `contractor_request-load-random-for_act`
  - `contractor_request-load-count-for_letter`
  - `contractor_request-load-random-for_letter`
  - `delete_contractor_request_stages`
  - `insert_contractor_request_stage`
  - `select-contractor_request_stages`
  - `delete_contractor_request_prints`
  - `insert_contractor_request_print`
  - `select-contractor_request_prints`
  - `delete_contractor_request_orders`
  - `insert_contractor_request_order`
  - `select-contractor_request_orders`
  - `select-contractors`

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
