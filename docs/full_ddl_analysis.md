# Full DDL Analysis (parsed from `db/lintera_full_ddl.sql`)

- Procedures found: **231**
- Triggers found: **127**

## Procedures inventory

| Name | Start line | Classification |
|---|---:|---|
| `CHECKUSERMESSAGESONDELETE` | 1360 | Service CRUD/validation |
| `DATE2STR` | 1362 | Service orchestration |
| `DCL_ADD_INFO_SERVICE_GUARANTEE` | 1366 | Service orchestration |
| `DCL_ASM_COUNT_BY_PRD_ID_ASM_ID` | 1376 | Service orchestration |
| `DCL_ASM_LIST_PRODUCES_LOAD` | 1383 | Service orchestration |
| `DCL_ASM_LIST_PRODUCE_LOAD` | 1395 | Service orchestration |
| `DCL_ASSEMBLE_FILTER` | 1407 | Service CRUD/validation |
| `DCL_ASSEMBLE_INSERT` | 1419 | Service CRUD/validation |
| `DCL_ASSEMBLE_LOAD` | 1429 | Service orchestration |
| `DCL_BEGIN_OF_NEXT_WEEK` | 1450 | Service orchestration |
| `DCL_BLANKS_LOAD` | 1454 | Service orchestration |
| `DCL_BLANK_INSERT` | 1466 | Service CRUD/validation |
| `DCL_BLANK_LOAD` | 1476 | Service orchestration |
| `DCL_CALCULATION_STATE` | 1488 | PL/pgSQL complex calc |
| `DCL_CALCULATION_STATE_DEBET` | 1566 | PL/pgSQL complex calc |
| `DCL_CAN_SPC_BLOCK` | 1624 | Service CRUD/validation |
| `DCL_CFC_MESSAGES_LOAD` | 1628 | Service orchestration |
| `DCL_CFC_PRODUCES_SELECT` | 1636 | Service orchestration |
| `DCL_CLOSED_RECORD_INSERT` | 1650 | Service CRUD/validation |
| `DCL_CLOSE_CONTRACT` | 1659 | Service CRUD/validation |
| `DCL_CLOSE_RESERVED_IN_CPR` | 1662 | Service CRUD/validation |
| `DCL_COMMERCIAL_PROPOSAL_FILTER` | 1664 | Service CRUD/validation |
| `DCL_COMMERCIAL_PROPOSAL_INSERT` | 1697 | Service CRUD/validation |
| `DCL_COND_FOR_CONTRACT_FILTER` | 1761 | Service CRUD/validation |
| `DCL_COND_FOR_CONTRACT_INSERT` | 1784 | Service CRUD/validation |
| `DCL_CONTACT_PERSON_INSERT` | 1813 | Service CRUD/validation |
| `DCL_CONTRACTOR_FILTER` | 1827 | Service CRUD/validation |
| `DCL_CONTRACTOR_FILTER_FULL` | 1833 | Service CRUD/validation |
| `DCL_CONTRACTOR_FOR_CC_FILTER` | 1859 | Service CRUD/validation |
| `DCL_CONTRACTOR_INSERT` | 1864 | Service CRUD/validation |
| `DCL_CONTRACTOR_LOAD` | 1885 | Service orchestration |
| `DCL_CONTRACTOR_REQUEST_FILTER` | 1915 | Service CRUD/validation |
| `DCL_CONTRACTOR_REQUEST_INSERT` | 1942 | Service CRUD/validation |
| `DCL_CONTRACTOR_REQUEST_LOAD` | 1970 | Service orchestration |
| `DCL_CONTRACTS_CLOSED_LOAD` | 2025 | Service CRUD/validation |
| `DCL_CONTRACT_CLOSED_FILTER` | 2047 | Service CRUD/validation |
| `DCL_CONTRACT_CLOSED_INSERT` | 2063 | Service CRUD/validation |
| `DCL_CONTRACT_FILTER` | 2068 | Service CRUD/validation |
| `DCL_CONTRACT_FOR_CC_FILTER` | 2101 | Service CRUD/validation |
| `DCL_CONTRACT_FOR_CONTRACTOR` | 2109 | Service orchestration |
| `DCL_CONTRACT_INSERT` | 2129 | Service CRUD/validation |
| `DCL_CON_LIST_SPECS_LOAD` | 2145 | Service orchestration |
| `DCL_CON_LIST_SPEC_INSERT` | 2183 | Service CRUD/validation |
| `DCL_CON_LIST_SPEC_LOAD` | 2213 | Service orchestration |
| `DCL_CON_MESSAGES_LOAD` | 2251 | Service orchestration |
| `DCL_COUNTRY_INSERT` | 2259 | Service CRUD/validation |
| `DCL_CPR_LIST_PRODUCES_LOAD` | 2263 | Service orchestration |
| `DCL_CPR_LIST_PRODUCE_LOAD` | 2289 | Service orchestration |
| `DCL_CPR_TRANSPORTS_LOAD` | 2315 | Service orchestration |
| `DCL_CPR_TRANSPORT_LOAD` | 2323 | Service orchestration |
| `DCL_CURRENCIES_RATES_FOR_DATE` | 2331 | Service orchestration |
| `DCL_CURRENCY_RATE_FOR_DATE` | 2338 | Service orchestration |
| `DCL_CURRENCY_RATE_MIN_DATE` | 2345 | Service orchestration |
| `DCL_CURRENT_WORKS_FILTER` | 2348 | Service CRUD/validation |
| `DCL_CURRENT_WORK_ADD_INFO` | 2372 | Service orchestration |
| `DCL_CUSTOM_CODE_FILTER` | 2378 | Service CRUD/validation |
| `DCL_DECODE_ID_LIST` | 2386 | Service orchestration |
| `DCL_DELETE_CONTRACT_CLOSED` | 2390 | Service CRUD/validation |
| `DCL_DELETE_DUPLICATE_CTN` | 2393 | Service CRUD/validation |
| `DCL_DELIVERY_REQUEST_FILTER` | 2397 | Service CRUD/validation |
| `DCL_DELIVERY_REQUEST_INSERT` | 2423 | Service CRUD/validation |
| `DCL_DEPARTMENT_FILTER` | 2439 | Service CRUD/validation |
| `DCL_DLR_COUNT_BY_PRD_ID_DLR_ID` | 2444 | Service orchestration |
| `DCL_DLR_LIST_PRODUCES_LOAD` | 2451 | Service orchestration |
| `DCL_DLR_LIST_PRODUCE_LOAD` | 2491 | Service orchestration |
| `DCL_DRP_DEPENDED_LINES` | 2533 | Service orchestration |
| `DCL_EQUIPMENT_FILTER` | 2540 | Service CRUD/validation |
| `DCL_EQUIPMENT_FOR_PRODUCE_LOAD` | 2564 | Service orchestration |
| `DCL_EQUIPMENT_GUARANTY_LOAD` | 2571 | Service orchestration |
| `DCL_EQUIPMENT_PNP_LOAD` | 2581 | Service orchestration |
| `DCL_GET_1C_BY_PRC_ID_PRD_ID` | 2591 | Service orchestration |
| `DCL_GET_ASM_LIST_FOR_ORD` | 2597 | Service orchestration |
| `DCL_GET_ASM_NUM_DATE_FOR_ORD` | 2601 | Service orchestration |
| `DCL_GET_ATT_COUNT_FOR_SPC` | 2605 | Service orchestration |
| `DCL_GET_BLANK_IMAGES_IN_STR` | 2609 | Service orchestration |
| `DCL_GET_CATEGORIES_FOR_TREE` | 2613 | Service orchestration |
| `DCL_GET_CHILD_CATEGORIES` | 2630 | Service orchestration |
| `DCL_GET_CIRC_AND_REST_FOR_PRD` | 2647 | Service orchestration |
| `DCL_GET_CONTRACTORS_FOR_FOR_ORD` | 2652 | Service orchestration |
| `DCL_GET_CONTRACTOR_FOR_FOR_ORD` | 2656 | Service orchestration |
| `DCL_GET_CON_NUM_FOR_DLR` | 2661 | Service orchestration |
| `DCL_GET_COUNT_DAY` | 2665 | Service orchestration |
| `DCL_GET_COUNT_OPR_USED_IN_ASM` | 2670 | Service orchestration |
| `DCL_GET_COUNT_REST_DRP` | 2674 | Service orchestration |
| `DCL_GET_CRQ_DELIVER` | 2679 | Service orchestration |
| `DCL_GET_CTN_NUM_LIST_BY_PRD_ID` | 2683 | Service orchestration |
| `DCL_GET_CUSTOMER_FOR_DLR` | 2688 | Service orchestration |
| `DCL_GET_DECODE_RESTS_IN_LIT` | 2692 | Service orchestration |
| `DCL_GET_DECODE_RESTS_IN_MINSK` | 2701 | Service orchestration |
| `DCL_GET_DOUBLE_CONTRACTOR` | 2710 | Service orchestration |
| `DCL_GET_DOUBLE_PRODUCES` | 2715 | Service orchestration |
| `DCL_GET_MANAGERS_BY_SHP_ID` | 2719 | Service orchestration |
| `DCL_GET_MANAGER_LIST_BY_SHP_ID` | 2723 | Service orchestration |
| `DCL_GET_NUM` | 2727 | Service orchestration |
| `DCL_GET_OCCUPIED_SHP_POS` | 2731 | Service orchestration |
| `DCL_GET_OPR_ID_BY_LPC` | 2735 | Service orchestration |
| `DCL_GET_OPR_ID_FROM_ASM` | 2742 | Service orchestration |
| `DCL_GET_ORD_CUST_INFO_FOR_ASM` | 2747 | Service orchestration |
| `DCL_GET_ORD_ID_BY_LPC` | 2751 | Service orchestration |
| `DCL_GET_ORD_INFO_FOR_ASM` | 2759 | Service orchestration |
| `DCL_GET_ORD_NUM_DATE_FOR_DLR` | 2767 | Service orchestration |
| `DCL_GET_PAYED_DATE` | 2771 | Service orchestration |
| `DCL_GET_PRC_LIST_FOR_ORD` | 2779 | Service orchestration |
| `DCL_GET_PRC_NUM_DATE_FOR_DRP` | 2783 | Service orchestration |
| `DCL_GET_PRC_NUM_DATE_FOR_ORD` | 2787 | Service orchestration |
| `DCL_GET_PRC_NUM_DATE_FOR_SIP` | 2791 | Service orchestration |
| `DCL_GET_PRODUCES_FOR_CAT` | 2795 | Service orchestration |
| `DCL_GET_PRODUCT_LIST_BY_SHP_ID` | 2819 | Service orchestration |
| `DCL_GET_RESERVED_COUNT_FOR_CPR` | 2823 | Service orchestration |
| `DCL_GET_RESERVED_INFO` | 2828 | Service orchestration |
| `DCL_GET_REST_ASM_FOR_DLR` | 2837 | Service orchestration |
| `DCL_GET_REST_ASM_FOR_PRC` | 2846 | Service orchestration |
| `DCL_GET_REST_DRP_FOR_PRC` | 2856 | Service orchestration |
| `DCL_GET_REST_DRP_FOR_SPI` | 2866 | Service orchestration |
| `DCL_GET_REST_INFO_FROM_ORDER` | 2876 | Service orchestration |
| `DCL_GET_REST_LPC_FOR_CPR` | 2882 | Service orchestration |
| `DCL_GET_REST_LPC_FOR_LPR` | 2898 | Service orchestration |
| `DCL_GET_REST_LPC_FOR_SHP` | 2903 | Service orchestration |
| `DCL_GET_REST_OPR_FOR_ASM` | 2927 | Service orchestration |
| `DCL_GET_REST_OPR_FOR_DLR` | 2936 | Service orchestration |
| `DCL_GET_REST_OPR_FOR_PRC` | 2952 | Service orchestration |
| `DCL_GET_REST_OPR_FOR_SPI` | 2964 | Service orchestration |
| `DCL_GET_REST_SIP_FOR_DLR` | 2976 | Service orchestration |
| `DCL_GET_REST_SIP_FOR_PRC` | 2985 | Service orchestration |
| `DCL_GET_ROW_SUM` | 2995 | Service orchestration |
| `DCL_GET_ROW_SUMM_EUR` | 3001 | Service orchestration |
| `DCL_GET_ROW_SUMM_OUT_NDS` | 3006 | Service orchestration |
| `DCL_GET_SPC_PAY_EXPIRATION` | 3011 | Service orchestration |
| `DCL_GET_SPI_LIST_FOR_ORD` | 3015 | Service orchestration |
| `DCL_GET_SPI_NUM_DATE_FOR_DRP` | 3019 | Service orchestration |
| `DCL_GET_SPI_NUM_DATE_FOR_ORD` | 3026 | Service orchestration |
| `DCL_GET_SUM_OUT_NDS_EUR` | 3033 | Service orchestration |
| `DCL_GET_SUM_OUT_NDS_EUR_PART` | 3037 | Service orchestration |
| `DCL_GET_TIMESTAMP_BREAKDOWN` | 3043 | Service orchestration |
| `DCL_GET_TREE` | 3051 | Service orchestration |
| `DCL_GET_USER_FOR_CONTRACT` | 3069 | Service orchestration |
| `DCL_GET_USR_DEP_LIST_CON` | 3075 | Service orchestration |
| `DCL_GET_USR_FOR_SPEC_IMP` | 3081 | Service orchestration |
| `DCL_GET_USR_ID_LIST_SHP` | 3085 | Service orchestration |
| `DCL_GOODS_CIRCULATION` | 3091 | Service orchestration |
| `DCL_GOODS_CIRCULATION_REST` | 3113 | Service orchestration |
| `DCL_GOODS_REST` | 3130 | Service orchestration |
| `DCL_INSTRUCTION_FILTER` | 3180 | Service CRUD/validation |
| `DCL_INSTRUCTION_INSERT` | 3197 | Service CRUD/validation |
| `DCL_INSTRUCTION_LOAD` | 3206 | Service orchestration |
| `DCL_IS_HAVE_EMPTY_DATE_CONF` | 3220 | Service orchestration |
| `DCL_IS_PAY_CLOSED` | 3226 | Service CRUD/validation |
| `DCL_IS_SHP_CLOSED` | 3230 | Service CRUD/validation |
| `DCL_IS_WARM_BY_DELIVERY_DATE` | 3234 | Service orchestration |
| `DCL_LOG_FILTER` | 3239 | Service CRUD/validation |
| `DCL_LOG_INSERT` | 3251 | Service CRUD/validation |
| `DCL_LOG_INSERT_BY_ACT_SYS_NAME` | 3256 | Service CRUD/validation |
| `DCL_MARGIN` | 3260 | PL/pgSQL complex calc |
| `DCL_MARGIN1` | 3323 | PL/pgSQL complex calc |
| `DCL_MONTAGE_ADJUSTMENT_INSERT` | 3379 | Service CRUD/validation |
| `DCL_MOVEMENT_LOAD` | 3385 | Service orchestration |
| `DCL_ORDERS_LOGISTICS` | 3421 | Entity lifecycle / audit |
| `DCL_ORDERS_STATISTICS` | 3438 | Service orchestration |
| `DCL_ORDERS_UNEXECUTED` | 3455 | Service orchestration |
| `DCL_ORDER_FILTER` | 3475 | Service CRUD/validation |
| `DCL_ORDER_INSERT` | 3526 | Service CRUD/validation |
| `DCL_ORDER_LOAD_CONTRACT` | 3591 | Service orchestration |
| `DCL_ORD_LIST_PRD_LOAD_PARENT` | 3597 | Service orchestration |
| `DCL_ORD_LIST_PRODUCES_LOAD` | 3604 | Service orchestration |
| `DCL_ORD_LIST_PRODUCE_INSERT` | 3638 | Service CRUD/validation |
| `DCL_ORD_LIST_PRODUCE_LOAD` | 3658 | Service orchestration |
| `DCL_ORD_MESSAGES_LOAD` | 3696 | Service orchestration |
| `DCL_OUTGOING_LETTER_FILTER` | 3703 | Service CRUD/validation |
| `DCL_OUTGOING_LETTER_INSERT` | 3716 | Service CRUD/validation |
| `DCL_OUTGOING_LETTER_LOAD` | 3725 | Service orchestration |
| `DCL_PAYMENT_FILTER` | 3741 | Service CRUD/validation |
| `DCL_PAYMENT_INSERT` | 3768 | Service CRUD/validation |
| `DCL_PAY_MESSAGES_LOAD` | 3781 | Service orchestration |
| `DCL_PRC_LIST_PRODUCES_LOAD` | 3794 | Service orchestration |
| `DCL_PRC_LIST_PRODUCE_LOAD` | 3831 | Service orchestration |
| `DCL_PROCESS_OPR_UNEXECUTED` | 3866 | Service orchestration |
| `DCL_PRODUCE_COST_FILTER` | 3870 | Service CRUD/validation |
| `DCL_PRODUCE_COST_INSERT` | 3884 | Service CRUD/validation |
| `DCL_PRODUCE_COST_REPORT` | 3894 | PL/pgSQL complex calc |
| `DCL_PRODUCE_COST_REPORT_SUM` | 3906 | PL/pgSQL complex calc |
| `DCL_PRODUCE_IN_SPC_IMPORT` | 3915 | Service orchestration |
| `DCL_SAVE_CFC_ECO_MSG` | 3919 | Service orchestration |
| `DCL_SAVE_CFC_MESSAGES` | 3926 | Service orchestration |
| `DCL_SAVE_CONTRACT_MESSAGES` | 3931 | Service orchestration |
| `DCL_SAVE_ORD_MESSAGES` | 3937 | Service orchestration |
| `DCL_SAVE_PAYMENT_MESSAGES` | 3943 | Service orchestration |
| `DCL_SERIAL_NUMBER_FILTER` | 3952 | Service CRUD/validation |
| `DCL_SHIPPING_FILTER` | 3961 | Service CRUD/validation |
| `DCL_SHIPPING_GOODS` | 3989 | Service orchestration |
| `DCL_SHIPPING_INSERT` | 4032 | Service CRUD/validation |
| `DCL_SHIPPING_REPORT` | 4055 | PL/pgSQL complex calc |
| `DCL_SHIPPING_REPORT_USER` | 4096 | PL/pgSQL complex calc |
| `DCL_SHP_LIST_PRODUCE_INSERT` | 4139 | Service CRUD/validation |
| `DCL_SIP_DEPENDED_LINES` | 4153 | Service orchestration |
| `DCL_SPECIFICATION_IMPORT_FILTER` | 4164 | Service CRUD/validation |
| `DCL_SPECIFICATION_IMPORT_INSERT` | 4177 | Service CRUD/validation |
| `DCL_SPI_COUNT_BY_PRD_ID_SPI_ID` | 4187 | Service orchestration |
| `DCL_SPI_LIST_PRODUCES_LOAD` | 4194 | Service orchestration |
| `DCL_SPI_LIST_PRODUCE_LOAD` | 4231 | Service orchestration |
| `DCL_STUFF_CATEGORY_FILTER` | 4266 | Service CRUD/validation |
| `DCL_TIMEBOARD_FILTER` | 4272 | Service CRUD/validation |
| `DCL_TIMEBOARD_INSERT` | 4280 | Service CRUD/validation |
| `DCL_TIMEBOARD_LOAD` | 4286 | Service orchestration |
| `DCL_TIMEBOARD_LOAD_CHECK_IDX` | 4298 | Service orchestration |
| `DCL_TMB_LIST_WORKS_LOAD` | 4303 | Service orchestration |
| `DCL_TMB_LIST_WORK_LOAD` | 4320 | Service orchestration |
| `DCL_UNCLOSED_SPEC` | 4337 | Service CRUD/validation |
| `DCL_UNIT_INSERT` | 4354 | Service CRUD/validation |
| `DCL_UNIT_PACK` | 4358 | Service orchestration |
| `DCL_UPDATE_DELIVERY_DATE` | 4362 | Service CRUD/validation |
| `DCL_UPDATE_DEP_DOCS_FOR_CTR` | 4365 | Service CRUD/validation |
| `DCL_UPDATE_DEP_DOCS_FOR_CUT` | 4369 | Service CRUD/validation |
| `DCL_UPDATE_DEP_DOCS_FOR_PRD` | 4373 | Service CRUD/validation |
| `DCL_UPDATE_DEP_DOCS_FOR_STF` | 4377 | Service CRUD/validation |
| `DCL_UPDATE_USER_BLOCK` | 4381 | Service CRUD/validation |
| `DCL_USER_ACTIONS` | 4385 | Service orchestration |
| `DCL_USER_FILTER` | 4390 | Service CRUD/validation |
| `DCL_USER_FILTER_FULL` | 4397 | Service CRUD/validation |
| `DCL_USER_INSERT` | 4415 | Service CRUD/validation |
| `DCL_YEARWEEK` | 4431 | Service orchestration |
| `GET_CONTEXT` | 4437 | Service orchestration |
| `GET_CONTRACTOR_FOR_FOR_APR_ID` | 4440 | Service orchestration |
| `GET_CONTRACTOR_FOR_FOR_DRP_ID` | 4451 | Service orchestration |
| `GET_CONTRACTOR_FOR_FOR_LPC_ID` | 4462 | Service orchestration |
| `GET_CONTRACTOR_FOR_FOR_OPR_ID` | 4474 | Service orchestration |
| `GET_CONTRACTOR_FOR_FOR_SIP_ID` | 4487 | Service orchestration |
| `GET_PRC_DATES_ON_STORAGE` | 4498 | Service orchestration |
| `MAINTENANCE_SELECTIVITY` | 4504 | Service orchestration |
| `MIGRATE_TO_CUSTOM_CODE_HISTORY` | 4506 | Service orchestration |
| `SET_CONTEXT` | 4508 | Service orchestration |
| `YEARWEEK` | 4511 | Service orchestration |

## Triggers inventory

| Name | Start line |
|---|---:|
| `DCL_1C_NUMBER_HISTORY_TRIGGER` | 25052 |
| `DCL_ACCOUNT_BI0` | 25062 |
| `DCL_ACCOUNT_BU0` | 25106 |
| `DCL_ACCOUNT_BD0` | 25158 |
| `DCL_ACTION_BI0` | 25185 |
| `DCL_ASM_LIST_PRODUCE_BI0` | 25202 |
| `DCL_ASSEMBLE_BI0` | 25219 |
| `DCL_ASSEMBLE_BU0` | 25240 |
| `DCL_ATTACHMENT_BIO` | 25248 |
| `DCL_BLANK_BI0` | 25272 |
| `DCL_BLANK_IMAGE_BI0` | 25289 |
| `DCL_CATALOG_NUMBER_BIO` | 25306 |
| `DCL_CATALOG_NUMBER_BU0` | 25323 |
| `DCL_CATEGORY_BIO` | 25334 |
| `DCL_CFC_LIST_PRODUCE_BI0` | 25351 |
| `DCL_CFC_MESSAGE_BI0` | 25368 |
| `DCL_COMMERCIAL_PROPOSAL_BI0` | 25387 |
| `DCL_COMMERCIAL_PROPOSAL_AI0` | 25408 |
| `DCL_COMMERCIAL_PROPOSAL_BU0` | 25420 |
| `DCL_COND_FOR_CONTRACT_BI0` | 25428 |
| `DCL_COND_FOR_CONTRACT_AI0` | 25460 |
| `DCL_COND_FOR_CONTRACT_BU0` | 25472 |
| `DCL_COND_FOR_CONTRACT_BD0` | 25508 |
| `DCL_CONTACT_PERSON_BI0` | 25515 |
| `DCL_CONTRACT_BI0` | 25532 |
| `DCL_CONTRACT_BU0` | 25554 |
| `DCL_CONTRACT_BD0` | 25562 |
| `DCL_CONTRACTOR_BI0` | 25569 |
| `DCL_CONTRACTOR_BU0` | 25591 |
| `DCL_CONTRACTOR_REQUEST_BI0` | 25599 |
| `DCL_CONTRACTOR_REQUEST_BU0` | 25620 |
| `DCL_CONTRACTOR_REQUEST_BD0` | 25628 |
| `DCL_CONTRACT_CLOSED_BI0` | 25635 |
| `DCL_CONTRACT_CLOSED_BU0` | 25662 |
| `DCL_CON_LIST_SPEC_BI0` | 25670 |
| `DCL_CON_LIST_SPEC_BD0` | 25687 |
| `DCL_CON_MESSAGE_BI0` | 25694 |
| `DCL_COUNTRY_BI0` | 25713 |
| `DCL_COUNTRY_BU0` | 25735 |
| `DCL_CPR_LIST_PRODUCE_BI0` | 25743 |
| `DCL_CPR_TRANSPORT_BI0` | 25760 |
| `DCL_CRQ_PRINT_BI0` | 25777 |
| `DCL_CRQ_STAGE_BI0` | 25794 |
| `DCL_CTC_LIST_BI0` | 25811 |
| `DCL_CTC_LIST_AD0` | 25828 |
| `DCL_CURRENCY_BIO` | 25843 |
| `DCL_CURRENCY_RATE_BI0` | 25860 |
| `DCL_CUSTOM_CODE_BI0` | 25877 |
| `DCL_CUSTOM_CODE_BU0` | 25896 |
| `DCL_CUSTOM_CODE_AU0` | 25903 |
| `DCL_CUS_CODE_HISTORY_TRIGGER` | 25913 |
| `DCL_DELIVERY_REQUEST_BI0` | 25923 |
| `DCL_DELIVERY_REQUEST_BU0` | 25950 |
| `DCL_DEPARTMENT_BI0` | 25963 |
| `DCL_DLR_LIST_PRODUCE_BI0` | 25980 |
| `DCL_DLR_LIST_PRODUCE_BU0` | 26006 |
| `DCL_DLR_LIST_PRODUCE_BD0` | 26051 |
| `DCL_FIELD_COMMENT_BI0` | 26087 |
| `DCL_FILES_PATH_BI0` | 26104 |
| `DCL_INF_MESSAGE_BI0` | 26121 |
| `DCL_INSTRUCTION_BI0` | 26140 |
| `DCL_INSTRUCTION_BU0` | 26161 |
| `DCL_INSTRUCTION_BD0` | 26169 |
| `DCL_INSTRUCTION_TYPE_BI0` | 26176 |
| `DCL_LANGUAGE_BI0` | 26193 |
| `DCL_LOG_BI0` | 26210 |
| `DCL_LPS_LIST_MANAGER_BI0` | 26233 |
| `DCL_MONTAGE_ADJUSTMENT_BIO` | 26250 |
| `DCL_MONTAGE_ADJUSTMENT_H_BIO` | 26267 |
| `DCL_MONTAGE_ADJUSTMENT_H_BU0` | 26287 |
| `DCL_ORDER_BI0` | 26295 |
| `DCL_ORDER_AI0` | 26316 |
| `DCL_ORDER_BU0` | 26331 |
| `DCL_ORDER_BD0` | 26339 |
| `DCL_ORD_LIST_PAYMENT_BI0` | 26346 |
| `DCL_ORD_LIST_PAY_SUM_BI0` | 26363 |
| `DCL_ORD_LIST_PRODUCE_BI0` | 26380 |
| `DCL_ORD_LIST_PRODUCE_AI0` | 26397 |
| `DCL_ORD_MESSAGE_BI0` | 26414 |
| `DCL_OUTGOING_LETTER_BI0` | 26433 |
| `DCL_OUTGOING_LETTER_BU0` | 26455 |
| `DCL_OUTGOING_LETTER_BD0` | 26463 |
| `DCL_PAYMENT_BI0` | 26470 |
| `DCL_PAYMENT_BU0` | 26492 |
| `DCL_PAY_LIST_SUMM_BI0` | 26500 |
| `DCL_PAY_MESSAGE_BI0` | 26517 |
| `DCL_PRC_LIST_PRODUCE_BI0` | 26536 |
| `DCL_PRC_LIST_PRODUCE_AI0` | 26562 |
| `DCL_PRC_LIST_PRODUCE_BU0` | 26596 |
| `DCL_PRC_LIST_PRODUCE_AU0` | 26641 |
| `DCL_PRC_LIST_PRODUCE_BD0` | 26670 |
| `DCL_PRODUCE_BIO` | 26706 |
| `DCL_PRODUCE_BD0` | 26723 |
| `DCL_PRODUCE_COST_BI0` | 26730 |
| `DCL_PRODUCE_COST_BU0` | 26752 |
| `DCL_PRODUCTION_TERM_BI0` | 26760 |
| `DCL_PURCHASE_PURPOSE_BI0` | 26777 |
| `DCL_PURPOSE_BI0` | 26794 |
| `DCL_RATE_NDS_BI0` | 26811 |
| `DCL_READY_FOR_SHIPPING_BI0` | 26828 |
| `DCL_REPUTATION_BI0` | 26845 |
| `DCL_REPUTATION_BU0` | 26867 |
| `DCL_ROLE_BIO` | 26877 |
| `DCL_ROUTE_BI0` | 26894 |
| `DCL_SELLER_BI0` | 26911 |
| `DCL_SETTING_BI0` | 26928 |
| `DCL_SHIPPING_BI0` | 26945 |
| `DCL_SHIPPING_BU0` | 26967 |
| `DCL_SHP_DOC_TYPE_BI0` | 26975 |
| `DCL_SHP_LIST_PRODUCE_BI0` | 26992 |
| `DCL_SHP_LIST_PRODUCE_AI0` | 27013 |
| `DCL_SHP_LIST_PRODUCE_BU0` | 27022 |
| `DCL_SHP_LIST_PRODUCE_AU0` | 27031 |
| `DCL_SPC_LIST_PAYMENT_BI0` | 27039 |
| `DCL_SPECIFICATION_IMPORT_BI0` | 27056 |
| `DCL_SPECIFICATION_IMPORT_BU0` | 27078 |
| `DCL_SPI_LIST_PRODUCE_BI0` | 27086 |
| `DCL_STUFF_CATEGORY_BI0` | 27103 |
| `DCL_TERM_INCO_BI0` | 27120 |
| `DCL_TEST_BI0` | 27137 |
| `DCL_TIMEBOARD_BI0` | 27154 |
| `DCL_TIMEBOARD_BU0` | 27181 |
| `DCL_TMB_LIST_WORK_BI0` | 27194 |
| `DCL_UNIT_BI0` | 27211 |
| `DCL_USER_BI0` | 27228 |
| `DCL_USER_LINK_BI0` | 27245 |
| `DCL_USER_SETTING_BI0` | 27264 |
