# Verify: login

## Static analysis
- Legacy: login JSP + action + permission checks.
- New: Spring Security is permissive currently; parity-hardening required for prod profile.

## Pseudo-tests
1. Valid credentials
   - Expected: authenticated session, route to personal office/dashboard.
2. Invalid credentials
   - Expected: login error screen parity.
3. Disabled login
   - Expected: `/login-disabled` behavior same as legacy lockout rules.
