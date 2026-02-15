# Payment Parity Map (draft)
## Scope
- Legacy JSP: `src/main/webapp/jsp/Payment.jsp`.
- Legacy Struts action mappings: `TBD (no direct input/forward mapping found in struts-config.xml)`

## Form beans
- `TBD`

## SQL/DAO inventory
- Candidate DAO classes:
  - `src/main/java/net/sam/dcl/dao/PaymentDAO.java`
- Candidate SQL resource IDs:
  - `select-payment_messages`
  - `delete-payment_message`
  - `save-payment_messages`
  - `select-not_closed_payments-for-spec`
  - `select-payments-for-spec`
  - `specification-load-for-payment`
  - `select-specification_payments`
  - `delete_specification_payments`
  - `insert_specification_payment`
  - `select-order_payments`
  - `delete_order_payments`
  - `insert_order_payment`
  - `select-payments`
  - `select-payments_by_spc_id`
  - `payment-insert`
  - `payment-update`
  - `payment-load`
  - `select-deleted_closed_record_payments`
  - `insert_closed_record_payment`
  - `delete_payment_msg_for_users`

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
