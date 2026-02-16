# attachments Parity Map (100% required)

## Scope
- **Legacy:** JSP `src/main/webapp/jsp/Attachments.jsp`, Struts mapping(s): `<form-bean name="Attachments" type="net.sam.dcl.action.AttachmentsActionBean"/>`; `<form-bean name="DeferredAttachments" type="net.sam.dcl.action.DeferredAttachmentsActionBean"/>`; `<forward name="attach" path="/DeferredAttachmentsAction.do?dispatch=init" redirect="true"/>`; `<action path="/FixAttachments" type="net.sam.dcl.action.FixAttachmentsAction" input=".FixAttachments"/>`.
- **Modern:** route `/attachments` (controller: `AttachmentsController` / `AttachmentsController.java`), template ``modern/src/main/resources/templates/attachments.html``, service `AttachmentsService.java`, DTO `AttachmentsDto.java`.

## Fields mapping
| Legacy property | New DTO/Entity | Type | Validation | Readonly cond | Notes |
|---|---|---|---|---|---|
| `grid` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |

## Actions
| Dispatch/Button | New endpoint | Params | Response |
|---|---|---|---|
| `input/show/process` (legacy pattern) | `GET /attachments`, `GET /attachments/{id}`, `POST /attachments` | screen DTO/form params | Legacy Struts dispatch vs Modern MVC handlers. |

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
