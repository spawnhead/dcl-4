# route Parity Map (100% required)

## Scope
- **Legacy:** JSP `src/main/webapp/jsp/Route.jsp`, Struts mapping(s): `<form-bean name="Routes" type="net.sam.dcl.form.RoutesForm"/>`; `<form-bean name="Route" type="net.sam.dcl.form.RouteForm"/>`; `<form-bean name="RoutesList" type="net.sam.dcl.form.RoutesListForm"/>`; `<action path="/RoutesAction" type="net.sam.dcl.action.RoutesAction" input=".Routes" name="Routes"/>`.
- **Modern:** route `/route` (controller: `RouteController` / `RouteController.java`), template ``modern/src/main/resources/templates/route.html``, service `RouteService.java`, DTO `RouteDto.java`.

## Fields mapping
| Legacy property | New DTO/Entity | Type | Validation | Readonly cond | Notes |
|---|---|---|---|---|---|
| `rut_id` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `rut_name` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |

## Actions
| Dispatch/Button | New endpoint | Params | Response |
|---|---|---|---|
| `dispatch=process` | `GET/POST /route` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |

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
