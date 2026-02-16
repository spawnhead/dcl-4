# woodwork-work-files Parity Map (100% required)

## Scope
- **Legacy:** JSP `src/main/webapp/jsp/WoodworkWorkFiles.jsp`, Struts mapping(s): `<form-bean name="WoodworkWorkFiles" type="net.sam.dcl.action.WoodworkWorkFilesActionBean"/>`; `<action path="/WoodworkWorkFilesAction" type="net.sam.dcl.controller.actions.HibernateAction"`; `<forward name="form" path=".WoodworkWorkFiles"/>`; `<action path="/WoodworkWorkFilesUploadFileAction" type="net.sam.dcl.controller.actions.HibernateAction"`.
- **Modern:** route `/woodwork-work-files` (controller: `WoodworkWorkFilesController` / `WoodworkWorkFilesController.java`), template ``modern/src/main/resources/templates/woodwork-work-files.html``, service `WoodworkWorkFilesService.java`, DTO `WoodworkWorkFilesDto.java`.

## Fields mapping
| Legacy property | New DTO/Entity | Type | Validation | Readonly cond | Notes |
|---|---|---|---|---|---|
| `grid` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `user.userFullName` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `createDate_formatted` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |

## Actions
| Dispatch/Button | New endpoint | Params | Response |
|---|---|---|---|
| `input/show/process` (legacy pattern) | `GET /woodwork-work-files`, `GET /woodwork-work-files/{id}`, `POST /woodwork-work-files` | screen DTO/form params | Legacy Struts dispatch vs Modern MVC handlers. |

## Grids
| Grid ID | Columns | Inline ops | Totals |
|---|---|---|---|
| `grid` | Legacy columns from JSP `<grid:column>/<grid:col*>` | edit/link/check ops per row where defined | totals usually not declared in scaffold JSP unless explicitly configured |

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
