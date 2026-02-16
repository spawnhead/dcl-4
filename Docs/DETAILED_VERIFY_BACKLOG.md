# Бэклог детальной верификации экранов (100% parity)

**Цель:** для каждого экрана из списка ниже другой ИИ должен выполнить **детальную верификацию** и либо дополнить существующий parity-документ до формата «Detailed», либо создать новый verify-документ. Итог — 100% паритет по полям, экшенам, гридам, печати/экспорту и статус **DONE** в конце документа.

---

## Инструкция для ИИ, выполняющего верификацию

1. **Прочитай** `AGENTS.md` (корень репозитория) — правила паритета и целевой стек.
2. **Эталон формата** — документы с детальной верификацией:
   - `docs/login_verify.md` (и `docs/parity/login.md` с полной Parity Map);
   - `docs/orders_verify.md`, `docs/users_verify.md`, `docs/shipping_verify.md`, `docs/commercial-proposal_verify.md`.
3. **Для каждого экрана из таблицы «Todo»**:
   - Изучи **Legacy:** `src/` — JSP, Action, Form, sql-resources.xml / DAO.
   - Изучи **Modern:** `modern/` — Controller, Service, DTO/Entity, шаблоны Thymeleaf.
   - Открой **scaffold** в `docs/parity/<screen>.md` и заполни все секции по шаблону Parity Map из AGENTS.md (Fields mapping, Actions, Grids, Print/Export, Validation, Readonly cond).
   - Создай или дополни **verify-документ**: либо `docs/<screen>_verify.md`, либо доведи `docs/parity/<screen>.md` до «Detailed» и в конце укажи `## Status: 100% (DONE)` или список открытых вопросов.
4. **Критерий готовности:** все поля/правила/экшены/гриды/печать описаны и помечены как проверенные (Y/Y в таблице статусов или явный DONE).

---

## Уже есть детальная верификация (5 экранов)

| № | Экран | Verify-документ | Parity scaffold |
|---|--------|-----------------|------------------|
| 1 | commercial-proposal | `docs/commercial-proposal_verify.md` | `docs/parity/commercial-proposal.md` |
| 2 | orders | `docs/orders_verify.md` | `docs/parity/order.md` + orders |
| 3 | users | `docs/users_verify.md` | `docs/parity/user.md` |
| 4 | login | `docs/login_verify.md` | `docs/parity/login.md` |
| 5 | shipping | `docs/shipping_verify.md` | `docs/parity/shipping.md` |

---

## Список экранов для детальной верификации (158 экранов, Todo)

ИИ должен по очереди взять экран, изучить Legacy + Modern, заполнить parity map и создать/обновить verify-документ.

| № | Screen ID | Scaffold (исходник) | Целевой verify-документ |
|---|-----------|---------------------|--------------------------|
| 6 | action | `docs/parity/action.md` | `docs/action_verify.md` или расширить parity |
| 7 | action-roles | `docs/parity/action-roles.md` | `docs/action-roles_verify.md` |
| 8 | actions | `docs/parity/actions.md` | `docs/actions_verify.md` |
| 9 | adm-zone | `docs/parity/adm-zone.md` | `docs/adm-zone_verify.md` |
| 10 | assemble | `docs/parity/assemble.md` | `docs/assemble_verify.md` |
| 11 | assemble-positions | `docs/parity/assemble-positions.md` | `docs/assemble-positions_verify.md` |
| 12 | assembles | `docs/parity/assembles.md` | `docs/assembles_verify.md` |
| 13 | attachments | `docs/parity/attachments.md` | `docs/attachments_verify.md` |
| 14 | blank | `docs/parity/blank.md` | `docs/blank_verify.md` |
| 15 | blanks | `docs/parity/blanks.md` | `docs/blanks_verify.md` |
| 16 | calculation-state | `docs/parity/calculation-state.md` | `docs/calculation-state_verify.md` |
| 17 | calculation-state-dev | `docs/parity/calculation-state-dev.md` | `docs/calculation-state-dev_verify.md` |
| 18 | calculation-state-just-grid | `docs/parity/calculation-state-just-grid.md` | `docs/calculation-state-just-grid_verify.md` |
| 19 | closed-record | `docs/parity/closed-record.md` | `docs/closed-record_verify.md` |
| 20 | commercial-proposal-produce | `docs/parity/commercial-proposal-produce.md` | `docs/commercial-proposal-produce_verify.md` |
| 21 | commercial-proposals | `docs/parity/commercial-proposals.md` | `docs/commercial-proposals_verify.md` |
| 22 | condition-for-contract | `docs/parity/condition-for-contract.md` | `docs/condition-for-contract_verify.md` |
| 23 | condition-for-contract-produce | `docs/parity/condition-for-contract-produce.md` | `docs/condition-for-contract-produce_verify.md` |
| 24 | conditions-for-contract | `docs/parity/conditions-for-contract.md` | `docs/conditions-for-contract_verify.md` |
| 25 | contact-person | `docs/parity/contact-person.md` | `docs/contact-person_verify.md` |
| 26 | contact-persons-list | `docs/parity/contact-persons-list.md` | `docs/contact-persons-list_verify.md` |
| 27 | contract | `docs/parity/contract.md` | `docs/contract_verify.md` |
| 28 | contract-closed | `docs/parity/contract-closed.md` | `docs/contract-closed_verify.md` |
| 29 | contractor | `docs/parity/contractor.md` | `docs/contractor_verify.md` |
| 30 | contractor-request | `docs/parity/contractor-request.md` | `docs/contractor-request_verify.md` |
| 31 | contractor-requests | `docs/parity/contractor-requests.md` | `docs/contractor-requests_verify.md` |
| 32 | contractors | `docs/parity/contractors.md` | `docs/contractors_verify.md` |
| 33 | contractors-for-contracts-closed-list | `docs/parity/contractors-for-contracts-closed-list.md` | `docs/contractors-for-contracts-closed-list_verify.md` |
| 34 | contractors-list | `docs/parity/contractors-list.md` | `docs/contractors-list_verify.md` |
| 35 | contracts | `docs/parity/contracts.md` | `docs/contracts_verify.md` |
| 36 | contracts-closed | `docs/parity/contracts-closed.md` | `docs/contracts-closed_verify.md` |
| 37 | contracts-dep-from-contractor-list | `docs/parity/contracts-dep-from-contractor-list.md` | `docs/contracts-dep-from-contractor-list_verify.md` |
| 38 | countries | `docs/parity/countries.md` | `docs/countries_verify.md` |
| 39 | country | `docs/parity/country.md` | `docs/country_verify.md` |
| 40 | currencies | `docs/parity/currencies.md` | `docs/currencies_verify.md` |
| 41 | currency | `docs/parity/currency.md` | `docs/currency_verify.md` |
| 42 | currency-rate | `docs/parity/currency-rate.md` | `docs/currency-rate_verify.md` |
| 43 | currency-rates | `docs/parity/currency-rates.md` | `docs/currency-rates_verify.md` |
| 44 | current-works | `docs/parity/current-works.md` | `docs/current-works_verify.md` |
| 45 | custom-code | `docs/parity/custom-code.md` | `docs/custom-code_verify.md` |
| 46 | custom-code-history | `docs/parity/custom-code-history.md` | `docs/custom-code-history_verify.md` |
| 47 | custom-codes | `docs/parity/custom-codes.md` | `docs/custom-codes_verify.md` |
| 48 | custom-codes-list | `docs/parity/custom-codes-list.md` | `docs/custom-codes-list_verify.md` |
| 49 | deferred-attachments | `docs/parity/deferred-attachments.md` | `docs/deferred-attachments_verify.md` |
| 50 | deferred-upload-file | `docs/parity/deferred-upload-file.md` | `docs/deferred-upload-file_verify.md` |
| 51 | delivery-request | `docs/parity/delivery-request.md` | `docs/delivery-request_verify.md` |
| 52 | delivery-request-positions | `docs/parity/delivery-request-positions.md` | `docs/delivery-request-positions_verify.md` |
| 53 | delivery-request-produce | `docs/parity/delivery-request-produce.md` | `docs/delivery-request-produce_verify.md` |
| 54 | delivery-requests | `docs/parity/delivery-requests.md` | `docs/delivery-requests_verify.md` |
| 55 | department | `docs/parity/department.md` | `docs/department_verify.md` |
| 56 | departments | `docs/parity/departments.md` | `docs/departments_verify.md` |
| 57 | dev-zone | `docs/parity/dev-zone.md` | `docs/dev-zone_verify.md` |
| 58 | equipment-list | `docs/parity/equipment-list.md` | `docs/equipment-list_verify.md` |
| 59 | error | `docs/parity/error.md` | `docs/error_verify.md` |
| 60 | files-path | `docs/parity/files-path.md` | `docs/files-path_verify.md` |
| 61 | files-paths | `docs/parity/files-paths.md` | `docs/files-paths_verify.md` |
| 62 | fix-attachments | `docs/parity/fix-attachments.md` | `docs/fix-attachments_verify.md` |
| 63 | global-lock-error | `docs/parity/global-lock-error.md` | `docs/global-lock-error_verify.md` |
| 64 | goods-circulation | `docs/parity/goods-circulation.md` | `docs/goods-circulation_verify.md` |
| 65 | goods-rest | `docs/parity/goods-rest.md` | `docs/goods-rest_verify.md` |
| 66 | goods-rest-in-minsk | `docs/parity/goods-rest-in-minsk.md` | `docs/goods-rest-in-minsk_verify.md` |
| 67 | goods-rest-lithuania | `docs/parity/goods-rest-lithuania.md` | `docs/goods-rest-lithuania_verify.md` |
| 68 | import-file | `docs/parity/import-file.md` | `docs/import-file_verify.md` |
| 69 | inco-terms-list | `docs/parity/inco-terms-list.md` | `docs/inco-terms-list_verify.md` |
| 70 | instruction | `docs/parity/instruction.md` | `docs/instruction_verify.md` |
| 71 | instruction-type | `docs/parity/instruction-type.md` | `docs/instruction-type_verify.md` |
| 72 | instruction-types | `docs/parity/instruction-types.md` | `docs/instruction-types_verify.md` |
| 73 | instructions | `docs/parity/instructions.md` | `docs/instructions_verify.md` |
| 74 | invitation | `docs/parity/invitation.md` | `docs/invitation_verify.md` |
| 75 | journals | `docs/parity/journals.md` | `docs/journals_verify.md` |
| 76 | language | `docs/parity/language.md` | `docs/language_verify.md` |
| 77 | languages | `docs/parity/languages.md` | `docs/languages_verify.md` |
| 78 | locked-records | `docs/parity/locked-records.md` | `docs/locked-records_verify.md` |
| 79 | locked-records.old | `docs/parity/locked-records.old.md` | `docs/locked-records.old_verify.md` |
| 80 | login-disabled | `docs/parity/login-disabled.md` | `docs/login-disabled_verify.md` |
| 81 | logs | `docs/parity/logs.md` | `docs/logs_verify.md` |
| 82 | margin | `docs/parity/margin.md` | `docs/margin_verify.md` |
| 83 | margin-dev | `docs/parity/margin-dev.md` | `docs/margin-dev_verify.md` |
| 84 | merge-contractors | `docs/parity/merge-contractors.md` | `docs/merge-contractors_verify.md` |
| 85 | montage-adjustment | `docs/parity/montage-adjustment.md` | `docs/montage-adjustment_verify.md` |
| 86 | montage-adjustment-history | `docs/parity/montage-adjustment-history.md` | `docs/montage-adjustment-history_verify.md` |
| 87 | montage-adjustments | `docs/parity/montage-adjustments.md` | `docs/montage-adjustments_verify.md` |
| 88 | montage-adjustments-history | `docs/parity/montage-adjustments-history.md` | `docs/montage-adjustments-history_verify.md` |
| 89 | multiple-file-upload | `docs/parity/multiple-file-upload.md` | `docs/multiple-file-upload_verify.md` |
| 90 | no-permission | `docs/parity/no-permission.md` | `docs/no-permission_verify.md` |
| 91 | nomenclature | `docs/parity/nomenclature.md` | `docs/nomenclature_verify.md` |
| 92 | nomenclature-produce | `docs/parity/nomenclature-produce.md` | `docs/nomenclature-produce_verify.md` |
| 93 | nomenclature-produce-custom-code-from-history | `docs/parity/nomenclature-produce-custom-code-from-history.md` | `docs/nomenclature-produce-custom-code-from-history_verify.md` |
| 94 | nomenclature-produce-custom-code-history | `docs/parity/nomenclature-produce-custom-code-history.md` | `docs/nomenclature-produce-custom-code-history_verify.md` |
| 95 | nomenclature-produces-merge | `docs/parity/nomenclature-produces-merge.md` | `docs/nomenclature-produces-merge_verify.md` |
| 96 | number1-c | `docs/parity/number1-c.md` | `docs/number1-c_verify.md` |
| 97 | number1-chistory | `docs/parity/number1-chistory.md` | `docs/number1-chistory_verify.md` |
| 98 | office | `docs/parity/office.md` | `docs/office_verify.md` |
| 99 | order | `docs/parity/order.md` | `docs/order_verify.md` |
| 100 | order-executed-produces | `docs/parity/order-executed-produces.md` | `docs/order-executed-produces_verify.md` |
| 101 | order-produce | `docs/parity/order-produce.md` | `docs/order-produce_verify.md` |
| 102 | orders-logistics | `docs/parity/orders-logistics.md` | `docs/orders-logistics_verify.md` |
| 103 | orders-statistics | `docs/parity/orders-statistics.md` | `docs/orders-statistics_verify.md` |
| 104 | orders-unexecuted | `docs/parity/orders-unexecuted.md` | `docs/orders-unexecuted_verify.md` |
| 105 | outgoing-letter | `docs/parity/outgoing-letter.md` | `docs/outgoing-letter_verify.md` |
| 106 | outgoing-letters | `docs/parity/outgoing-letters.md` | `docs/outgoing-letters_verify.md` |
| 107 | pay-sum | `docs/parity/pay-sum.md` | `docs/pay-sum_verify.md` |
| 108 | payment | `docs/parity/payment.md` | `docs/payment_verify.md` |
| 109 | payments | `docs/parity/payments.md` | `docs/payments_verify.md` |
| 110 | personal-office | `docs/parity/personal-office.md` | `docs/personal-office_verify.md` |
| 111 | produce-cost | `docs/parity/produce-cost.md` | `docs/produce-cost_verify.md` |
| 112 | produce-cost-custom | `docs/parity/produce-cost-custom.md` | `docs/produce-cost-custom_verify.md` |
| 113 | produce-cost-positions | `docs/parity/produce-cost-positions.md` | `docs/produce-cost-positions_verify.md` |
| 114 | produce-cost-produce | `docs/parity/produce-cost-produce.md` | `docs/produce-cost-produce_verify.md` |
| 115 | produce-cost-report | `docs/parity/produce-cost-report.md` | `docs/produce-cost-report_verify.md` |
| 116 | produce-movement | `docs/parity/produce-movement.md` | `docs/produce-movement_verify.md` |
| 117 | produces-cost | `docs/parity/produces-cost.md` | `docs/produces-cost_verify.md` |
| 118 | produces-for-assemble-minsk | `docs/parity/produces-for-assemble-minsk.md` | `docs/produces-for-assemble-minsk_verify.md` |
| 119 | purchase-purpose | `docs/parity/purchase-purpose.md` | `docs/purchase-purpose_verify.md` |
| 120 | purchase-purposes | `docs/parity/purchase-purposes.md` | `docs/purchase-purposes_verify.md` |
| 121 | purpose | `docs/parity/purpose.md` | `docs/purpose_verify.md` |
| 122 | purposes | `docs/parity/purposes.md` | `docs/purposes_verify.md` |
| 123 | rate-nds | `docs/parity/rate-nds.md` | `docs/rate-nds_verify.md` |
| 124 | rates-nds | `docs/parity/rates-nds.md` | `docs/rates-nds_verify.md` |
| 125 | references | `docs/parity/references.md` | `docs/references_verify.md` |
| 126 | reloader | `docs/parity/reloader.md` | `docs/reloader_verify.md` |
| 127 | reports | `docs/parity/reports.md` | `docs/reports_verify.md` |
| 128 | reputation | `docs/parity/reputation.md` | `docs/reputation_verify.md` |
| 129 | reputations | `docs/parity/reputations.md` | `docs/reputations_verify.md` |
| 130 | role | `docs/parity/role.md` | `docs/role_verify.md` |
| 131 | roles | `docs/parity/roles.md` | `docs/roles_verify.md` |
| 132 | route | `docs/parity/route.md` | `docs/route_verify.md` |
| 133 | routes | `docs/parity/routes.md` | `docs/routes_verify.md` |
| 134 | seller | `docs/parity/seller.md` | `docs/seller_verify.md` |
| 135 | sellers | `docs/parity/sellers.md` | `docs/sellers_verify.md` |
| 136 | sellers-list | `docs/parity/sellers-list.md` | `docs/sellers-list_verify.md` |
| 137 | serial-number-list | `docs/parity/serial-number-list.md` | `docs/serial-number-list_verify.md` |
| 138 | sessions | `docs/parity/sessions.md` | `docs/sessions_verify.md` |
| 139 | setting | `docs/parity/setting.md` | `docs/setting_verify.md` |
| 140 | settings | `docs/parity/settings.md` | `docs/settings_verify.md` |
| 141 | shipping-doc-type | `docs/parity/shipping-doc-type.md` | `docs/shipping-doc-type_verify.md` |
| 142 | shipping-doc-types | `docs/parity/shipping-doc-types.md` | `docs/shipping-doc-types_verify.md` |
| 143 | shipping-positions | `docs/parity/shipping-positions.md` | `docs/shipping-positions_verify.md` |
| 144 | shipping-report | `docs/parity/shipping-report.md` | `docs/shipping-report_verify.md` |
| 145 | shippings | `docs/parity/shippings.md` | `docs/shippings_verify.md` |
| 146 | specification | `docs/parity/specification.md` | `docs/specification_verify.md` |
| 147 | specification-import | `docs/parity/specification-import.md` | `docs/specification-import_verify.md` |
| 148 | specification-import-positions | `docs/parity/specification-import-positions.md` | `docs/specification-import-positions_verify.md` |
| 149 | specification-imports | `docs/parity/specification-imports.md` | `docs/specification-imports_verify.md` |
| 150 | specifications-dep-from-contract-list | `docs/parity/specifications-dep-from-contract-list.md` | `docs/specifications-dep-from-contract-list_verify.md` |
| 151 | stuff-categories | `docs/parity/stuff-categories.md` | `docs/stuff-categories_verify.md` |
| 152 | stuff-category | `docs/parity/stuff-category.md` | `docs/stuff-category_verify.md` |
| 153 | timeboard | `docs/parity/timeboard.md` | `docs/timeboard_verify.md` |
| 154 | timeboard-work | `docs/parity/timeboard-work.md` | `docs/timeboard-work_verify.md` |
| 155 | timeboards | `docs/parity/timeboards.md` | `docs/timeboards_verify.md` |
| 156 | unit | `docs/parity/unit.md` | `docs/unit_verify.md` |
| 157 | units | `docs/parity/units.md` | `docs/units_verify.md` |
| 158 | upload-file | `docs/parity/upload-file.md` | `docs/upload-file_verify.md` |
| 159 | user | `docs/parity/user.md` | `docs/user_verify.md` |
| 160 | user-roles | `docs/parity/user-roles.md` | `docs/user-roles_verify.md` |
| 161 | user-setting | `docs/parity/user-setting.md` | `docs/user-setting_verify.md` |
| 162 | user-settings | `docs/parity/user-settings.md` | `docs/user-settings_verify.md` |
| 163 | woodwork-work-files | `docs/parity/woodwork-work-files.md` | `docs/woodwork-work-files_verify.md` |

---

## Шаблон секций для детального verify-документа

Используй структуру из AGENTS.md (Parity Map):

```markdown
# <Screen> Parity Map (100% required)

## Scope
[URL, dispatch, JSP path] — Legacy; [Modern route, template].

## Fields mapping
| Legacy property | New DTO/Entity | Type | Validation | Readonly cond | Notes |

## Actions
| Dispatch/Button | New endpoint | Params | Response |

## Grids
| Grid ID | Columns | Inline ops | Totals |

## Print/Export
| Type | Params | Output format | Parity check |

## Status: XX/YY (100% = DONE)
Open issues: []
```

При создании отдельного `docs/<screen>_verify.md` можно сократить до статического анализа + псевдо-тестов (как в `orders_verify.md`), но тогда в `docs/parity/<screen>.md` должна быть полная Parity Map со Status: 100% (DONE).

---

## Сводка

| Категория | Количество |
|-----------|------------|
| Уже с детальной верификацией | 5 |
| Осталось для детальной верификации | 158 |
| **Всего экранов** | **163** |

После выполнения бэклога обнови `docs/parity-verify-status.md`: в колонке Status замени Scaffold на Detailed и укажи путь к verify-документу в колонке Verify doc.
