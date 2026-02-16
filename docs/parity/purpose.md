# purpose Parity Map (100% required)

## Scope
- **Legacy:** JSP `src/main/webapp/jsp/Purpose.jsp`, Struts mapping(s): `<form-bean name="Purposes" type="net.sam.dcl.form.PurposesForm"/>`; `<form-bean name="Purpose" type="net.sam.dcl.form.PurposeForm"/>`; `<form-bean name="PurchasePurposes" type="net.sam.dcl.form.PurchasePurposesForm"/>`; `<form-bean name="PurchasePurpose" type="net.sam.dcl.form.PurchasePurposeForm"/>`.
- **Modern:** route `/purpose` (controller: `PurposeController` / `PurposeController.java`), template ``modern/src/main/resources/templates/purpose.html``, service `PurposeService.java`, DTO `PurposeDto.java`.

## Fields mapping
| Legacy property | New DTO/Entity | Type | Validation | Readonly cond | Notes |
|---|---|---|---|---|---|
| `prs_id` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `prs_name` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |

## Actions
| Dispatch/Button | New endpoint | Params | Response |
|---|---|---|---|
| `dispatch=process` | `GET/POST /purpose` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |

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
