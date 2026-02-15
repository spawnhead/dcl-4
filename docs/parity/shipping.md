# Shipping Parity Map (draft)
## Scope
- Legacy JSP: `src/main/webapp/jsp/Shipping.jsp`.
- Legacy Struts action mappings: `TBD (no direct input/forward mapping found in struts-config.xml)`

## Form beans
- `TBD`

## SQL/DAO inventory
- Candidate DAO classes:
  - `src/main/java/net/sam/dcl/dao/ShippingDocTypeDAO.java`
  - `src/main/java/net/sam/dcl/dao/ShippingPositionDAO.java`
  - `src/main/java/net/sam/dcl/dao/ShippingDAO.java`
- Candidate SQL resource IDs:
  - `select-shippings`
  - `select-shipping_by_spc_id`
  - `shipping-load`
  - `shipping-insert`
  - `shipping-update`
  - `shipping-update-block`
  - `shipping-set-block`
  - `shipping-positions-available`
  - `shipping_position-load`
  - `select-shipping-positions`
  - `shipping_position-delete`
  - `shipping_position-insert`
  - `shipping_position-update`
  - `shipping_position-rut_id`
  - `select-shipping_managers`
  - `select-shipping_products`
  - `shipping_position_occupied-load`
  - `select-managers_for_shipping_position`
  - `delete-managers_for_shipping_position`
  - `insert-managers_for_shipping_position`

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
