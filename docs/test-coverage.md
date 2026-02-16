# Test Coverage Report Template

## Smoke parity coverage
- Target screens: **163** (all files in `docs/parity/*.md`, excluding `README.md`)
- Current generator scope: **first 10 screens** (skeleton stage)
- Runtime report output: `src/test/resources/reports/parity-smoke-latest.md`

## Report columns
| Column | Description |
|---|---|
| Screen | Parity screen slug (`docs/parity/<slug>.md`) |
| GET path | Route inferred from parity markdown |
| GET | HTTP status for smoke GET |
| POST | HTTP status for minimal form POST |
| Status | PASS/FAIL per dynamic smoke assertion |
| Notes | Failure context |

## CI usage
```bash
mvn test -Dtest=ParitySmokeTests
```

## Expansion plan to 163/163
1. Remove `INITIAL_SCREEN_LIMIT` in `ParitySmokeTests`.
2. Add route normalization map for non-trivial legacy URLs.
3. Tune key field extraction per parity file conventions.
4. Keep markdown report artifact for CI publishing.
