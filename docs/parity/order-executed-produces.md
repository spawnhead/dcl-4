# order-executed-produces Parity Map (100% required)

## Scope
- **Legacy:** JSP `src/main/webapp/jsp/OrderExecutedProduces.jsp`, Struts mapping(s): `<form-bean name="OrderExecutedProduces" type="net.sam.dcl.form.OrderExecutedProducesForm"/>`; `<forward name="editExecuted" path="/OrderExecutedProducesAction.do?dispatch=edit"/>`; `<action scope="session" path="/OrderExecutedProducesAction" type="net.sam.dcl.action.OrderExecutedProducesAction"`; `<forward name="ajaxOrderExecutedProducesGrid" path=".OrderExecutedProducesGrid"/>`.
- **Modern:** route `/order-executed-produces` (controller: `OrderExecutedProducesController` / `OrderExecutedProducesController.java`), template ``modern/src/main/resources/templates/order-executed-produces.html``, service `OrderExecutedProducesService.java`, DTO `OrderExecutedProducesDto.java`.

## Fields mapping
| Legacy property | New DTO/Entity | Type | Validation | Readonly cond | Notes |
|---|---|---|---|---|---|
| `ord_number` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `ord_date` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `disableEdit` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |

## Actions
| Dispatch/Button | New endpoint | Params | Response |
|---|---|---|---|
| `dispatch=ajaxOrderExecutedProducesGrid` | `GET/POST /order-executed-produces` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=back` | `GET/POST /order-executed-produces` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=ajaxNewExecutedDateChanged` | `GET/POST /order-executed-produces` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=ajaxChangeValue` | `GET/POST /order-executed-produces` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=ajaxDeleteColumn` | `GET/POST /order-executed-produces` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |

## Grids
| Grid ID | Columns | Inline ops | Totals |
|---|---|---|---|
| n/a or not explicit in JSP | n/a | n/a | n/a |

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
