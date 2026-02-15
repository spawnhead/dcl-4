# Legacy procedure call refactor status

## Inventory command
```bash
rg -n "EXECUTE PROCEDURE|SELECT .*PROCEDURE|execute procedure" src
```

## Current status
- Legacy raw procedure calls still exist in legacy Struts SQL resources (`src/main/webapp/WEB-INF/classes/resources/sql-resources.xml`) and some DAO classes.
- Migration batches implemented:
  - `V003__Commercial_and_Order_procs.sql` (4)
  - `V004__Next_procs.sql` (20)
  - `V005__Batch3_next50_procs.sql` (50)
- SQL migrated so far: **74/231** procedures.
- Full 231/231 planning/classification and screen mapping: `docs/proc_migration_status.md`.

## Next batches
1. Continue `V006..V010` for critical PL/pgSQL procedures with full input/output signatures.
2. Move remaining `sql-resources.xml` procedure entries to Spring repositories/services per bounded context.
3. Delete legacy DB procedure indirection after parity validation.
