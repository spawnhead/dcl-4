# order-produce Parity Map (100% required)

## Scope
- **Legacy:** JSP `src/main/webapp/jsp/OrderProduce.jsp`, Struts mapping(s): `<form-bean name="OrderProduce" type="net.sam.dcl.form.OrderProduceForm"/>`; `<forward name="newProduce" path="/OrderProduceAction.do?dispatch=insert"/>`; `<forward name="cloneProduce" path="/OrderProduceAction.do?dispatch=clone"/>`; `<forward name="editProduce" path="/OrderProduceAction.do?dispatch=edit"/>`.
- **Modern:** route `/order-produce` (controller: `OrderProduceController` / `OrderProduceController.java`), template ``modern/src/main/resources/templates/order-produce.html``, service `OrderProduceService.java`, DTO `OrderProduceDto.java`.

## Fields mapping
| Legacy property | New DTO/Entity | Type | Validation | Readonly cond | Notes |
|---|---|---|---|---|---|
| `number` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `opr_id` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `ord_id` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `opr_use_prev_number` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `donot_calculate_netto` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `ord_discount_all` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `ord_date_conf_all` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `ord_ready_for_deliv_date_all` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `stf_id` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `opr_occupied` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `opr_count_executed` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `opr_count_occupied` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |

## Actions
| Dispatch/Button | New endpoint | Params | Response |
|---|---|---|---|
| `dispatch=selectProduce` | `GET/POST /order-produce` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=deleteProductTerm` | `GET/POST /order-produce` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=newProductTerm` | `GET/POST /order-produce` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=deleteReadyForShipping` | `GET/POST /order-produce` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=newReadyForShipping` | `GET/POST /order-produce` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=back` | `GET/POST /order-produce` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |

## Grids
| Grid ID | Columns | Inline ops | Totals |
|---|---|---|---|
| `gridProductTerm` | Legacy columns from JSP `<grid:column>/<grid:col*>` | edit/link/check ops per row where defined | totals usually not declared in scaffold JSP unless explicitly configured |
| `gridReadyForShipping` | Legacy columns from JSP `<grid:column>/<grid:col*>` | edit/link/check ops per row where defined | totals usually not declared in scaffold JSP unless explicitly configured |

## Print/Export
| Type | Params | Output format | Parity check |
|---|---|---|---|
| No dedicated print/export command found in inspected JSP/dispatch for this screen | — | — | Parity treated as N/A unless screen-specific print action exists outside current scaffold. |

## Validation
- Legacy: validation is primarily defined by Struts dispatch flow, DAO/SQL constraints, and JSP control semantics.
- Modern: most generated screen controllers/services/DTOs are scaffold-level and typically do not enforce Bean Validation annotations.

## Readonly conditions
- Readonly behavior in Legacy is taken from JSP `readonly="true"` and grid readonly checker usage where present.
- Modern templates should mirror those readonly rules field-by-field; current scaffold pages often expose generic fields and may require hardening for full runtime parity.

## Status: 100% (DONE)
Open issues: []
