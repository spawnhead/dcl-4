# Verify: condition-for-contract-produce

## Static analysis
- Legacy artifacts reviewed: `src/main/webapp/jsp/ConditionForContractProduce.jsp`, Struts mapping(s), and SQL/DAO resources for screen-related identifiers.
- Modern artifacts reviewed: controller `ConditionForContractProduceController`, template `modern/src/main/resources/templates/condition-for-contract-produce.html`, service `ConditionForContractProduceService.java`, DTO `ConditionForContractProduceDto.java`.
- Detailed parity map is maintained in `docs/parity/condition-for-contract-produce.md` with full sections and DONE status.

## Field and behavior parity summary
1. Legacy field surface (sample): `number`, `ccp_id`, `cpr_id`, `cpr_number`, `cpr_date`, `sellerId`.
2. Modern field surface (sample): `id`, `action`, `payload`.
3. Main parity check: map each legacy dispatch/form/grid behavior to modern route/controller/template handling and record any structural gaps.

## Pseudo-tests
1. Open screen input/list route
   - Legacy: open corresponding `...Action.do?dispatch=input|show|execute`.
   - Modern: `GET /condition-for-contract-produce` returns the screen template with DTO/model.
2. Edit/process flow
   - Legacy: execute form submit with dispatch-specific button and verify expected navigation/back behavior.
   - Modern: submit `POST /condition-for-contract-produce` and verify returned template/model/save indicator (or redirect if implemented).
3. Grid/readonly/print-export checks
   - Verify grid columns/inline operations and readonly rules from parity map.
   - If print/export exists, verify parameter and output format parity; otherwise mark N/A.

## Conclusion
- Static documentation parity for `condition-for-contract-produce` is completed to Detailed format; runtime parity depth depends on current modern implementation maturity and should be validated by integration tests when business logic is wired.
