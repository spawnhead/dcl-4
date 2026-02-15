# Verify: users

## Static analysis
- Legacy user-related procedures: `dcl_update_user_block`, user-role/user-setting paths.
- New migration status: wrapper present in `V004`; service/controller full parity remains pending.

## Pseudo-tests
1. Block/unblock user
   - Input: user id + block flag.
   - Expected: function returns affected user id; user state toggled.
2. Role assignment
   - Expected parity with legacy role constraints once mapped in service layer.
3. User settings update
   - Expected persisted settings and UI round-trip.
