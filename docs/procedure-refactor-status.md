# Legacy procedure call refactor status

## Inventory command
```bash
rg -n "EXECUTE PROCEDURE|SELECT .*PROCEDURE|execute procedure" src
```

## Current status
- Legacy raw procedure calls still exist in legacy Struts SQL resources (`src/main/webapp/WEB-INF/classes/resources/sql-resources.xml`) and some legacy DAO classes.
- Modernized path now exposes priority replacements via:
  - `dcl_commercial_proposal_insert`
  - `dcl_commercial_proposal_filter`
  - `dcl_order_filter`
  - `dcl_close_reserved_in_cpr`
- Java service adapters implemented in:
  - `net.sam.dcl.modern.service.CommercialProposalService`
  - `net.sam.dcl.modern.service.OrdersService`

## Next batches
1. Move `sql-resources.xml` procedure entries to Spring repositories/services per bounded context.
2. Replace DAO-level `execute procedure` invocations in `src/main/java/net/sam/dcl/dao/*` with Spring services.
3. Delete legacy DB procedure indirection after parity validation.
