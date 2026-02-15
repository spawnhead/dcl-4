# Order Parity Map (draft)
## Scope
- Legacy JSP: `src/main/webapp/jsp/Order.jsp`.
- Legacy Struts action mappings: `TBD (no direct input/forward mapping found in struts-config.xml)`

## Form beans
- `TBD`

## SQL/DAO inventory
- Candidate DAO classes:
  - `src/main/java/net/sam/dcl/dao/OrderProduceDAO.java`
  - `src/main/java/net/sam/dcl/dao/OrderDAO.java`
- Candidate SQL resource IDs:
  - `select-order_messages`
  - `delete-order_message`
  - `save-order_messages`
  - `order-positions-available-for-delivery-request`
  - `order-positions-available-for-assemble`
  - `order-positions-available-for-specification-import`
  - `select-orders`
  - `order-insert`
  - `order-update`
  - `order-update_scale`
  - `order-update-block`
  - `order-load`
  - `order-load-assemblies`
  - `order-load-specifications_import`
  - `order-load-cost_produces`
  - `order-load-contract`
  - `order-load_by_opr_id`
  - `order-load_id_by_produce_cost_produce`
  - `order-load-warn`
  - `order-load-count`

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
