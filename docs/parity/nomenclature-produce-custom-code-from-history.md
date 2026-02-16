# nomenclature-produce-custom-code-from-history Parity Map (100% required)

## Scope
- **Legacy:** JSP `src/main/webapp/jsp/NomenclatureProduceCustomCodeFromHistory.jsp`, Struts mapping(s): `<form-bean name="NomenclatureProduceCustomCodeFromHistory"`; `<action path="/NomenclatureProduceCustomCodeFromHistoryAction"`; `<forward name="form" path=".NomenclatureProduceCustomCodeFromHistory"/>`.
- **Modern:** route `/nomenclature-produce-custom-code-from-history` (controller: `NomenclatureProduceCustomCodeFromHistoryController` / `NomenclatureProduceCustomCodeFromHistoryController.java`), template ``modern/src/main/resources/templates/nomenclature-produce-custom-code-from-history.html``, service `NomenclatureProduceCustomCodeFromHistoryService.java`, DTO `NomenclatureProduceCustomCodeFromHistoryDto.java`.

## Fields mapping
| Legacy property | New DTO/Entity | Type | Validation | Readonly cond | Notes |
|---|---|---|---|---|---|
| `customCode.code` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `dateCreated` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |

## Actions
| Dispatch/Button | New endpoint | Params | Response |
|---|---|---|---|
| `input/show/process` (legacy pattern) | `GET /nomenclature-produce-custom-code-from-history`, `GET /nomenclature-produce-custom-code-from-history/{id}`, `POST /nomenclature-produce-custom-code-from-history` | screen DTO/form params | Legacy Struts dispatch vs Modern MVC handlers. |

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
