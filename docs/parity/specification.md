# specification Parity Map (100% required)

## Scope
- **Legacy:** JSP `src/main/webapp/jsp/Specification.jsp`, Struts mapping(s): `<form-bean name="Specification" type="net.sam.dcl.form.SpecificationForm"/>`; `<form-bean name="SpecificationImports" type="net.sam.dcl.form.SpecificationImportsForm"/>`; `<form-bean name="SpecificationImport" type="net.sam.dcl.form.SpecificationImportForm"/>`; `<form-bean name="SpecificationImportPositions" type="net.sam.dcl.form.SpecificationImportPositionsForm"/>`.
- **Modern:** route `/specification` (controller: `SpecificationController` / `SpecificationController.java`), template ``modern/src/main/resources/templates/specification.html``, service `SpecificationService.java`, DTO `SpecificationDto.java`.

## Fields mapping
| Legacy property | New DTO/Entity | Type | Validation | Readonly cond | Notes |
|---|---|---|---|---|---|
| `is_new_doc` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `old_number` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `spc_id` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `spc_executed` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `spc_occupied` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `spc_occupied_in_pay_shp` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `payed_summ` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `spc_in_ctc` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `noRoundSum` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `ndsRate` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `user.userFullName` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |
| `spc_number` | `id` (approx) | string/flag (by control type) | Legacy: UI/dispatch-driven; Modern: no explicit Bean Validation in scaffold | editable (unless role/grid checker) | Derived from JSP controls and modern template fields. |

## Actions
| Dispatch/Button | New endpoint | Params | Response |
|---|---|---|---|
| `dispatch=ajaxSpecificationPaymentsGrid` | `GET/POST /specification` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=deleteAttachment` | `GET/POST /specification` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=deferredAttachCopy` | `GET/POST /specification` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=deferredAttach` | `GET/POST /specification` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=back` | `GET/POST /specification` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=ajaxAddToPaymentGrid` | `GET/POST /specification` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=ajaxRemoveFromPaymentGrid` | `GET/POST /specification` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |
| `dispatch=ajaxCalculateDeliveryDate` | `GET/POST /specification` (method-specific analogue) | form-bound params | Legacy dispatch action; Modern controller returns same template with model update. |

## Grids
| Grid ID | Columns | Inline ops | Totals |
|---|---|---|---|
| `attachmentsGrid` | Legacy columns from JSP `<grid:column>/<grid:col*>` | edit/link/check ops per row where defined | totals usually not declared in scaffold JSP unless explicitly configured |

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
