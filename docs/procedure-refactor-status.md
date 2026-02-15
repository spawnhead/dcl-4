# Legacy procedure call refactor status

## Inventory command
```bash
rg -n "EXECUTE PROCEDURE|SELECT .*PROCEDURE|execute procedure" src
```

## Current status
- Legacy raw procedure calls still exist in legacy Struts SQL resources (`src/main/webapp/WEB-INF/classes/resources/sql-resources.xml`) and some legacy DAO classes.
- Modernized path now exposes **24/231** migrated procedures via:
  - Batch1: `dcl_commercial_proposal_insert`, `dcl_commercial_proposal_filter`, `dcl_order_filter`, `dcl_close_reserved_in_cpr`.
  - Batch2 (`V004__Next_procs.sql`): message/save/log/update wrappers for high-call `EXECUTE PROCEDURE` entries.
- Java service adapters implemented in:
  - `net.sam.dcl.modern.service.CommercialProposalService`
  - `net.sam.dcl.modern.service.OrdersService`
  - `net.sam.dcl.modern.service.LegacyProcedureGateway`

## Next batches
1. Move remaining `sql-resources.xml` procedure entries to Spring repositories/services per bounded context.
2. Replace DAO-level `execute procedure` invocations in `src/main/java/net/sam/dcl/dao/*` with Spring services.
3. Delete legacy DB procedure indirection after parity validation.
