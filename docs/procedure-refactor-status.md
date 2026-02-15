# Legacy procedure call refactor status

## Inventory command
```bash
rg -n "EXECUTE PROCEDURE|SELECT .*PROCEDURE|execute procedure" src src_modern
```

## Current status
- `src_modern/` does not contain legacy `EXECUTE PROCEDURE` calls.
- Procedure migration batches present in `src/main/resources/db/migration` and mirrored in `src_modern/resources/db/migration`:
  - `V003` .. `V010`
- Migration status target reached in docs: **231/231 ✅**.

## Remaining technical debt
1. Replace compatibility wrappers with full signature/logic parity per screen priority.
2. Execute runtime parity suite against legacy data snapshots.
3. Cut over per `docs/CUTOVER.md`.
