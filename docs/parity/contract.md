# Contract Parity Map (draft)
## Scope
- Legacy JSP: `src/main/webapp/jsp/Contract.jsp`.
- Legacy Struts action mappings: `TBD (no direct input/forward mapping found in struts-config.xml)`

## Form beans
- `TBD`

## SQL/DAO inventory
- Candidate DAO classes:
  - `src/main/java/net/sam/dcl/dao/ConditionForContractDAO.java`
  - `src/main/java/net/sam/dcl/dao/ContractDAO.java`
  - `src/main/java/net/sam/dcl/dao/ContractClosedDAO.java`
  - `src/main/java/net/sam/dcl/dao/ContractorDAO.java`
  - `src/main/java/net/sam/dcl/dao/ContractorRequestDAO.java`
- Candidate SQL resource IDs:
  - `select-contract_messages`
  - `delete-contract_message`
  - `save-contract_messages`
  - `select-condition_for_contract_messages`
  - `delete-condition_for_contract_message`
  - `save-condition_for_contract_messages`
  - `save-condition_for_contract_messages_for_economist`
  - `delete-condition_for_contract_messages_for_economist`
  - `select-conditions_for_contract`
  - `condition_for_contract-insert`
  - `condition_for_contract-update`
  - `execute_condition_for_contract`
  - `select-cfc_specifications_numbers-for-contract-id`
  - `condition_for_contract-update-checkPrice`
  - `condition_for_contract-load`
  - `select-condition_for_contract_produces`
  - `insert_condition_for_contract_produce`
  - `delete_condition_for_contract_produces`
  - `select-contracts`
  - `select-contracts-for-contractor-id`

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
