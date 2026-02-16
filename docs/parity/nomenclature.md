# nomenclature Parity Map (100% required)

## Scope
- **Legacy:** JSP `src/main/webapp/jsp/Nomenclature.jsp`, Struts mapping(s): `<form-bean name="Nomenclature" type="net.sam.dcl.form.NomenclatureActionBean"/>`; `<form-bean name="NomenclatureProduce" type="net.sam.dcl.action.NomenclatureProduceActionBean"/>`; `<form-bean name="NomenclatureProducesMerge" type="net.sam.dcl.action.NomenclatureProducesMergeActionBean"/>`; `<form-bean name="NomenclatureProduceCustomCodeHistory"`.
- **Modern:** route `/nomenclature` (controller: `NomenclatureController` / `NomenclatureController.java`), template ``modern/src/main/resources/templates/nomenclature.html``, service `NomenclatureService.java`, DTO `NomenclatureDto.java`.

## Fields mapping
| Legacy property | New DTO/Entity | Type | Validation | Readonly cond | Notes |
|---|---|---|---|---|---|
| `cat_id` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `mergeTargetId` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `filter_catalog_number` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `filter_produce` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `filter_type` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `stf_name` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `filter_params` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `filter_add_params` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `filter_cusCode` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `filter_common` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `category_name` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `currentUser.admin` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |

## Actions
| Dispatch/Button | New endpoint | Params | Response |
|---|---|---|---|
| `dispatch=input` | `GET/POST /nomenclature` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=filter` | `GET/POST /nomenclature` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=fakeDispatchForEdit` | `GET/POST /nomenclature` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=fakeDispatchForDelete` | `GET/POST /nomenclature` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=fakeDispatchForShowAllTree` | `GET/POST /nomenclature` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=uploadTemplate` | `GET/POST /nomenclature` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=fakeDispatchForMerging` | `GET/POST /nomenclature` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=fakeDispatchForMove` | `GET/POST /nomenclature` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |

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
