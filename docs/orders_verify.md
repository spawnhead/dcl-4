# Verify: orders

## Static analysis
- Legacy: order filtering and procedure calls in `sql-resources.xml` (`dcl_order_filter`, order message procedures).
- New: `OrdersService.filterByProcedure` delegates to `dcl_order_filter`.

## Pseudo-tests
1. Filter by order number fragment
   - Input: `ORD-2026`.
   - Expected: sorted descending by date/id, same as legacy function semantics.
2. Empty filter
   - Expected: returns unfiltered list window, same ordering.
3. Future parity extension
   - Expected once wired: order message save goes through `LegacyProcedureGateway.saveOrderMessage`.
