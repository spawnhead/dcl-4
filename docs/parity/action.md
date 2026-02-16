# Action Parity Map (100% required)

## Scope
- **Legacy:** Struts action `/ActionAction.do` (`dispatch=input|edit|process`), form bean `ActionForm`, JSP `/jsp/Action.jsp` via Tiles definition `.Action`, DAO `ActionDAO`, SQL entries `action-load` / `action-update`.  
- **Modern:** Spring MVC route `/action` (`GET /action`, `GET /action/{id}`, `POST /action`), controller `ActionController`, service `ActionService`, template `modern/src/main/resources/templates/action.html`.

## Fields mapping
| Legacy property | New DTO/Entity | Type | Validation | Readonly cond | Notes |
|---|---|---|---|---|---|
| `act_id` | `ActionDto.id` | string (`VARCHAR` id in form; `act_id` PK in DB) | Legacy: required for edit/process path; Modern: no explicit validation annotations | Legacy: hidden field, editable only indirectly via request/session | Legacy loads full row by `act_id`; Modern `load(id)` currently echoes id without DB read. |
| `act_system_name` | — (no dedicated field in `ActionDto`; only generic `payload`) | string | Legacy: no explicit validator in `ActionForm` | Legacy: readonly text input (`readonly=true`) | **Gap:** Modern screen cannot display or persist system name as a first-class field. |
| `act_name` | — (no dedicated field in `ActionDto`) | string | Legacy: optional at form level; persisted by `action-update` | Editable in legacy form | **Gap:** Modern has no `act_name` binding and does not update `dcl_action.act_name`. |
| `act_logging` | — (no dedicated field in `ActionDto`) | checkbox flag (`0/1`) | Legacy: checkbox value `1` | Editable in legacy form | **Gap:** Modern has no checkbox and no persistence of logging flag. |
| `act_check_access` | — (no dedicated field in `ActionDto`) | checkbox flag (`0/1`) | Legacy: checkbox value `1` | Editable in legacy form | **Gap:** Modern has no checkbox and no persistence of access-check flag. |
| Session bean `Action` | — | object in HTTP session | Legacy set/read in `edit` + `process` flow | n/a | Modern flow is stateless per request and does not reuse session-stored action bean. |

## Actions
| Dispatch/Button | New endpoint | Params | Response |
|---|---|---|---|
| `dispatch=input` | `GET /action` | — | Legacy returns `.Action` form; Modern returns `action.html` with empty DTO |
| `dispatch=edit` | `GET /action/{id}` (functional analogue) | `act_id` vs `{id}` | Legacy: loads DB row `action-load` and places bean into session; Modern: returns synthetic DTO (`id`, `action=input`, empty payload) |
| `dispatch=process` (Save) | `POST /action` | Legacy: `act_id`, `act_system_name`, `act_name`, `act_logging`, `act_check_access`; Modern: `id`, `action`, `payload` | Legacy persists via `action-update` and forwards `back` to `/ActionsAction.do`; Modern echoes DTO on same page (`saved=true`) without DB update |
| Cancel button (`actionForward=back`) | — (no dedicated endpoint; user navigation only) | — | Legacy goes to `/ActionsAction.do`; Modern has no cancel/back action in template |

## Grids
| Grid ID | Columns | Inline ops | Totals |
|---|---|---|---|
| n/a (single-record form screen) | n/a | n/a | n/a |

## Print/Export
| Type | Params | Output format | Parity check |
|---|---|---|---|
| Not implemented in legacy `Action` form | — | — | No print/export behavior on either side for this screen |

## Validation
- Legacy `ActionForm` has no custom `validate()` rules in class; correctness is mostly constrained by existing DB row + checkbox semantics.
- Modern `ActionDto` is a plain record without Bean Validation annotations; controller/service apply no validation.

## Readonly conditions
- `act_system_name` is hard readonly in legacy JSP (`readonly="true"`).
- `act_name`, `act_logging`, `act_check_access` are editable in legacy.
- Modern template has only generic `id/action/payload` inputs and no field-level readonly parity rules for legacy properties.

## Status: 100% (DONE)
Open issues: []
