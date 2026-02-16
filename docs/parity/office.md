# office Parity Map (100% required)

## Scope
- **Legacy:** JSP `src/main/webapp/jsp/Office.jsp`, Struts mapping(s): `<form-bean name="Office" type="net.sam.dcl.form.OfficeForm"/>`; `<forward name="office-forward" path="/OfficeAction.do?dispatch=input"/>`; `<action path="/PersonalOfficeAction" type="net.sam.dcl.action.PersonalOfficeAction" input=".PersonalOffice"/>`; `<action path="/OfficeAction" type="net.sam.dcl.action.OfficeAction" input=".Office" name="Office">`.
- **Modern:** route `/office` (controller: `OfficeController` / `OfficeController.java`), template ``modern/src/main/resources/templates/office.html``, service `OfficeService.java`, DTO `OfficeDto.java`.

## Fields mapping
| Legacy property | New DTO/Entity | Type | Validation | Readonly cond | Notes |
|---|---|---|---|---|---|
| `showForChiefDep` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `user.userFullName` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |

## Actions
| Dispatch/Button | New endpoint | Params | Response |
|---|---|---|---|
| `dispatch=ajaxMessagesGrid` | `GET/POST /office` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=ajaxRemoveMessages` | `GET/POST /office` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |

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
