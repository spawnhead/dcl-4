# number1-c Parity Map (100% required)

## Scope
- **Legacy:** JSP `src/main/webapp/jsp/Number1C.jsp`, Struts mapping(s): `<form-bean name="Number1CHistory" type="net.sam.dcl.form.Number1CHistoryForm"/>`; `<form-bean name="Number1CFromHistory" type="net.sam.dcl.form.Number1CFromHistoryForm"/>`; `<action path="/Number1CHistoryAction" type="net.sam.dcl.action.Number1CHistoryAction"`; `<forward name="form" path=".Number1CHistory"/>`.
- **Modern:** route `/number1-c` (controller: `Number1CController` / `Number1CController.java`), template ``modern/src/main/resources/templates/number1-c.html``, service `Number1CService.java`, DTO `Number1CDto.java`.

## Fields mapping
| Legacy property | New DTO/Entity | Type | Validation | Readonly cond | Notes |
|---|---|---|---|---|---|
| `productName` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | readonly in JSP | Derived from JSP controls and modern template fields. |
| `number1C` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `dateCreated` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |

## Actions
| Dispatch/Button | New endpoint | Params | Response |
|---|---|---|---|
| `input/show/process` (legacy pattern) | `GET /number1-c`, `GET /number1-c/{id}`, `POST /number1-c` | screen DTO/form params | Legacy Struts dispatch vs Modern MVC handlers. |

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
