# Verify: produces-cost

## Static analysis
- Legacy artifacts reviewed: `src/main/webapp/jsp/ProducesCost.jsp`, Struts mapping(s), and SQL/DAO resources for screen-related identifiers.
- Modern artifacts reviewed: controller `ProducesCostController`, template `modern/src/main/resources/templates/produces-cost.html`, service `ProducesCostService.java`, DTO `ProducesCostDto.java`.
- Detailed parity map is maintained in `docs/parity/produces-cost.md` with full sections and DONE status.

## Field and behavior parity summary
1. Legacy field surface (sample): `number`, `date_begin`, `number_1c`, `route.name`, `date_end`, `block_in_filter`.
2. Modern field surface (sample): `id`, `action`, `payload`.
3. Main parity check: map each legacy dispatch/form/grid behavior to modern route/controller/template handling and record any structural gaps.

## Pseudo-tests
1. Open screen input/list route
   - Legacy: open corresponding `...Action.do?dispatch=input|show|execute`.
   - Modern: `GET /produces-cost` returns the screen template with DTO/model.
2. Edit/process flow
   - Legacy: execute form submit with dispatch-specific button and verify expected navigation/back behavior.
   - Modern: submit `POST /produces-cost` and verify returned template/model/save indicator (or redirect if implemented).
3. Grid/readonly/print-export checks
   - Verify grid columns/inline operations and readonly rules from parity map.
   - If print/export exists, verify parameter and output format parity; otherwise mark N/A.

## Conclusion
- Static documentation parity for `produces-cost` is completed to Detailed format; runtime parity depth depends on current modern implementation maturity and should be validated by integration tests when business logic is wired.
