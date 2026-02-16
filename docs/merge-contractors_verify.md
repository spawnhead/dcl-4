# Verify: merge-contractors

## Static analysis
- Legacy artifacts reviewed: `src/main/webapp/jsp/MergeContractors.jsp`, Struts mapping(s), and SQL/DAO resources for screen-related identifiers.
- Modern artifacts reviewed: controller `MergeContractorsController`, template `modern/src/main/resources/templates/merge-contractors.html`, service `MergeContractorsService.java`, DTO `MergeContractorsDto.java`.
- Detailed parity map is maintained in `docs/parity/merge-contractors.md` with full sections and DONE status.

## Field and behavior parity summary
1. Legacy field surface (sample): `oldId`, `newId`, `leftName`, `contractorLeft.name`, `leftFullName`, `contractorLeft.fullname`.
2. Modern field surface (sample): `id`, `action`, `payload`.
3. Main parity check: map each legacy dispatch/form/grid behavior to modern route/controller/template handling and record any structural gaps.

## Pseudo-tests
1. Open screen input/list route
   - Legacy: open corresponding `...Action.do?dispatch=input|show|execute`.
   - Modern: `GET /merge-contractors` returns the screen template with DTO/model.
2. Edit/process flow
   - Legacy: execute form submit with dispatch-specific button and verify expected navigation/back behavior.
   - Modern: submit `POST /merge-contractors` and verify returned template/model/save indicator (or redirect if implemented).
3. Grid/readonly/print-export checks
   - Verify grid columns/inline operations and readonly rules from parity map.
   - If print/export exists, verify parameter and output format parity; otherwise mark N/A.

## Conclusion
- Static documentation parity for `merge-contractors` is completed to Detailed format; runtime parity depth depends on current modern implementation maturity and should be validated by integration tests when business logic is wired.
