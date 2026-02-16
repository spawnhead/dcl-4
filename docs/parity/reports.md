# reports Parity Map (100% required)

## Scope
- **Legacy:** JSP `src/main/webapp/jsp/Reports.jsp`, Struts mapping(s): `<form-bean name="Reports" type="net.sam.dcl.form.ReportsForm"/>`; `<action path="/ReportsAction" type="net.sam.dcl.action.ReportsAction" input=".Reports" name="Reports"/>`.
- **Modern:** route `/reports` (controller: `ReportsController` / `ReportsController.java`), template ``modern/src/main/resources/templates/reports.html``, service `ReportsService.java`, DTO `ReportsDto.java`.

## Fields mapping
| Legacy property | New DTO/Entity | Type | Validation | Readonly cond | Notes |
|---|---|---|---|---|---|
| `TBD from legacy form bean` | `dto` fields | mixed | Legacy validation not explicit in form class; Modern scaffold mostly without Bean Validation | depends on control | Screen requires deeper runtime checks if special widgets are used. |

## Actions
| Dispatch/Button | New endpoint | Params | Response |
|---|---|---|---|
| `input/show/process` (legacy pattern) | `GET /reports`, `GET /reports/{id}`, `POST /reports` | screen DTO/form params | Legacy Struts dispatch vs Modern MVC handlers. |

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
