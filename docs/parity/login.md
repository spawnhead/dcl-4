# Login Parity Map (100% required)

## Scope
- **Legacy:** JSP `src/main/webapp/jsp/login.jsp`, Struts action `/trusted/Login` (LoginAction), Form `LoginForm`.
- **Modern:** GET `/login` — страница входа, POST `/login/process` — обработка формы (Spring Security).

## Form beans / DTO
- Legacy: `LoginForm` — поля `usr_login`, `usr_passwd` (из запроса).
- Modern: форма Thymeleaf `login.html` с полями `usr_login`, `usr_passwd`; обработка Spring Security (UsernamePasswordAuthenticationFilter).

## SQL/DAO (Legacy)
- `user-load-login` — загрузка пользователя по `usr_login` (без пароля).
- `user-load-login_pwd` — проверка по `usr_login` и `usr_passwd` (plain text).
- DAOUtils.load в `LoginAction`: сначала user-load-login, затем user-load-login_pwd; при успехе — User в сессию, redirect на invitation-forward.

## Fields mapping
| Legacy property | New (Modern) | Type | Validation | Readonly | Notes |
|-----------------|--------------|------|------------|----------|-------|
| usr_login       | name="usr_login" | text | required | no | Параметр Spring Security: usernameParameter |
| usr_passwd      | name="usr_passwd" | password | required | no | passwordParameter |

## Actions
| Legacy | Modern | Params | Response |
|--------|--------|--------|----------|
| POST form → /trusted/Login?dispatch=process | POST → /login/process | usr_login, usr_passwd | 302 → /references (success) или /login?error (failure) |
| GET страницы входа | GET /login | — | 200 login.html |
| Выход | POST /logout | — | 302 → /login?logout |

## Auth logic (parity)
- Пользователь из `dcl_user` по `usr_login`; пароль сравнивается как строка (Legacy: plain text; Modern: NoOpPasswordEncoder).
- `usr_block = 1` → пользователь заблокирован (Modern: User.disabled).
- После входа: редирект на главную (Modern: `/references`; Legacy: invitation-forward).

## Print/Export
Не применимо (экран входа).

## Seed пользователь (dev)
Повторяемая миграция `R__seed_admin_user.sql`: логин **admin**, пароль **admin** (при отсутствии пользователя с USR_LOGIN='admin').

## Status: 100% (DONE)
Open issues: []
