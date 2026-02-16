-- Повторяемая миграция: тестовый пользователь для входа (parity с Legacy login).
-- Логин: admin, пароль: admin. После первого успешного входа пароль лучше сменить.

INSERT INTO dcl_language (LNG_ID, LNG_NAME, LNG_LETTER_ID)
SELECT 1, 'Русский', 'ru'
WHERE NOT EXISTS (SELECT 1 FROM dcl_language WHERE LNG_ID = 1);

INSERT INTO dcl_user (
    USR_ID, USR_CODE, USR_LOGIN, USR_PASSWD, DEP_ID,
    USR_PHONE, USR_BLOCK, USR_RESPONS_PERSON, USR_NO_LOGIN, USR_CHIEF_DEP,
    USR_FAX, USR_EMAIL, USR_LOCAL_ENTRY, USR_INTERNET_ENTRY
)
SELECT 1, '001', 'admin', 'admin', NULL,
    NULL, 0, 0, 0, NULL,
    NULL, NULL, 1, 1
WHERE NOT EXISTS (SELECT 1 FROM dcl_user WHERE USR_LOGIN = 'admin');

INSERT INTO dcl_user_language (USR_ID, LNG_ID, USR_SURNAME, USR_NAME, USR_POSITION)
SELECT 1, 1, 'Админов', 'Админ', 'Администратор'
WHERE NOT EXISTS (SELECT 1 FROM dcl_user_language WHERE USR_ID = 1 AND LNG_ID = 1);
