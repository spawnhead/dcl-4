# Verify: produces-for-assemble-minsk

## Static analysis
- Legacy artifacts reviewed: `src/main/webapp/jsp/ProducesForAssembleMinsk.jsp`, Struts mapping(s), and SQL/DAO resources for screen-related identifiers.
- Modern artifacts reviewed: controller `ProducesForAssembleMinskController`, template `modern/src/main/resources/templates/produces-for-assemble-minsk.html`, service `ProducesForAssembleMinskService.java`, DTO `ProducesForAssembleMinskDto.java`.
- Detailed parity map is maintained in `docs/parity/produces-for-assemble-minsk.md` with full sections and DONE status.

## Field and behavior parity summary
1. Legacy field surface (sample): `route.name`, `prc_date_min`, `name_filter`, `ctn_number`, `number_1c`, `gridLeft`.
2. Modern field surface (sample): `id`, `action`, `payload`.
3. Main parity check: map each legacy dispatch/form/grid behavior to modern route/controller/template handling and record any structural gaps.

## Pseudo-tests
1. Open screen input/list route
   - Legacy: open corresponding `...Action.do?dispatch=input|show|execute`.
   - Modern: `GET /produces-for-assemble-minsk` returns the screen template with DTO/model.
2. Edit/process flow
   - Legacy: execute form submit with dispatch-specific button and verify expected navigation/back behavior.
   - Modern: submit `POST /produces-for-assemble-minsk` and verify returned template/model/save indicator (or redirect if implemented).
3. Grid/readonly/print-export checks
   - Verify grid columns/inline operations and readonly rules from parity map.
   - If print/export exists, verify parameter and output format parity; otherwise mark N/A.

## Conclusion
- Static documentation parity for `produces-for-assemble-minsk` is completed to Detailed format; runtime parity depth depends on current modern implementation maturity and should be validated by integration tests when business logic is wired.
