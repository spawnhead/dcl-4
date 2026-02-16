# Verify: action

## Static analysis
- Legacy flow is fully CRUD-update oriented for one row in `dcl_action`: `edit` loads by `act_id`, `process` updates `act_name`, `act_logging`, `act_check_access`, and then redirects back to actions list.
- Legacy keeps edited entity in HTTP session (`StoreUtil`) between `edit` and `process`.
- Modern `/action` implementation is scaffold-level: `ActionService.load()` returns synthetic DTO and `process()` returns the input DTO without DB interaction.

## Field and behavior parity summary
1. **Identifier parity:** partial (`act_id` ↔ `ActionDto.id`), but modern does not use it for repository lookup.
2. **Business fields parity:** missing (`act_system_name`, `act_name`, `act_logging`, `act_check_access` are absent from modern DTO/template).
3. **Readonly parity:** missing (`act_system_name` readonly behavior absent in modern).
4. **Navigation parity:** missing (legacy cancel/back to `/ActionsAction.do`; modern has no back action).
5. **Persistence parity:** missing (legacy `action-update` SQL; modern no persistence call).

## Pseudo-tests
1. Open existing action for edit
   - Legacy: `/ActionAction.do?dispatch=edit&act_id=...` shows DB-backed values.
   - Modern: `GET /action/{id}` shows id plus default placeholders.
2. Save edited action name/flags
   - Legacy: updates row in `dcl_action`, visible in `Actions` list.
   - Modern: shows `Saved` message only; no durable update.
3. Verify readonly system name
   - Legacy: `act_system_name` cannot be edited in UI.
   - Modern: no equivalent field, so rule is not represented.

## Conclusion
- Documentation parity mapping is complete (see `docs/parity/action.md`), but runtime feature parity for the `action` screen is currently not implemented in the modern module.
