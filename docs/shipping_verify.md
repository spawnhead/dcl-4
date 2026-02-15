# Verify: shipping

## Static analysis
- Legacy shipping procedures: `dcl_shipping_*`, `dcl_shp_*` branches.
- New: wrapper migration in SQL batches; service/controller deep parity pending.

## Pseudo-tests
1. Create shipping document
   - Expected: header + lines persisted; totals recalculated.
2. Shipping report
   - Expected: report output fields and totals match legacy.
3. Shipping close/block flow
   - Expected: state transitions and readonly mode parity.
