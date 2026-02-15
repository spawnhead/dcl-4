# Commercial Proposal Parity Map (100% required)

## Scope
- Legacy URL: `/commercialProposal.do?dispatch=*` + `/commercialProposals.do?dispatch=*`.
- Legacy JSP: `src/main/webapp/jsp/CommercialProposal.jsp`, `CommercialProposals.jsp`, `CommercialProposalProduce.jsp`, `ajax/ProducesCommercialProposalGrid.jsp`.
- Legacy Action/Form: `CommercialProposalAction`, `CommercialProposalsAction`, `CommercialProposalProduceAction`, `CommercialProposalPrintAction`, `CommercialProposalImportAction` + corresponding `*Form` classes.

## Fields mapping
| Legacy property | New DTO/Entity | Type | Validation | Readonly cond | Notes |
|-----------------|----------------|------|------------|---------------|-------|
| cpr_id | id | Integer | required on edit | read-only | PK |
| cpr_number | number | String(20) | required | read-only after generation | document number |
| cpr_date | date | LocalDate | required | editable by role | proposal date |
| contractor.id | contractorId | Integer | required | by role | CTR_ID |
| contactPerson.cps_id | contactPersonId | Integer | optional | by contractor | CPS_ID |
| blank.bln_id | blankId | Integer | required | usually fixed by template | BLN_ID |
| cpr_concerning | concerning | String(1000) | optional | editable | text |
| cpr_concerning_invoice | concerningInvoice | String(1000) | optional | editable | invoice text |
| cpr_preamble | preamble | String(1000) | optional | editable | preamble |
| currency.id | currencyId | Integer | required | editable | CUR_ID |
| currencyTable.id | tableCurrencyId | Integer | required | editable | CUR_ID_TABLE |
| cpr_course | course | BigDecimal(18,8) | optional | recalculated via ajaxChangeCourse | exchange rate |
| cpr_nds | nds | BigDecimal(15,2) | optional | recalculated via ajaxChangeNDS | VAT |
| priceCondition.id | priceConditionId | Integer | required | editable | TRM_ID_PRICE_CONDITION |
| cpr_country | country | String(32) | optional | editable | country |
| cpr_pay_condition | payCondition | String(1000) | optional | editable | payment condition |
| cpr_pay_condition_invoice | payConditionInvoice | String(1000) | optional | editable | invoice payment condition |
| deliveryCondition.id | deliveryConditionId | Integer | required | editable | TRM_ID_DELIVERY_CONDITION |
| cpr_delivery_address | deliveryAddress | String(256) | optional | editable | address |
| cpr_sum_transport | sumTransport | BigDecimal(15,2) | optional | editable/auto | totals |
| cpr_all_transport | allTransport | Short/Boolean | optional | toggle | distribute transport |
| cpr_sum_assembling | sumAssembling | BigDecimal(15,2) | optional | by role | assembling total |
| cpr_delivery_term | deliveryTerm | String(2000) | optional | editable | delivery term |
| cpr_delivery_term_invoice | deliveryTermInvoice | String(2000) | optional | editable | invoice delivery term |
| cpr_add_info | addInfo | String(3000) | optional | editable | additional info |
| cpr_final_date | finalDate | LocalDate | optional | editable | final date |
| cpr_final_date_invoice | finalDateInvoice | String(30) | optional | editable | invoice final date text |
| user.usr_id | userId | Integer | optional | role-controlled | responsible user |
| executor.usr_id | executorId | Integer | optional | role-controlled | executor |
| cpr_executor_flag | executorFlag | Short/Boolean | optional | toggle | use executor |
| cpr_date_accept | dateAccept | LocalDate | optional | dateAcceptReadOnly | acceptance date |
| cpr_proposal_received_flag | proposalReceivedFlag | Short/Boolean | default false | dateAcceptReadOnly | proposal received |
| cpr_proposal_declined | proposalDeclined | Char(1)/Boolean | default '0' | role-controlled | decline flag |
| cpr_block | block | Short/Boolean | optional | role-controlled | blocked state |
| cpr_summ | summary | BigDecimal(15,2) | calculated | read-only | grand total |
| cpr_nds_by_string | ndsByString | Short/Boolean | optional | toggle | print VAT as text |
| cpr_old_version | oldVersion | Short/Boolean | optional | disabled in read-only | old/new version mode |
| cpr_assemble_minsk_store | assembleMinskStore | Short/Boolean | optional | role-controlled | special calculation mode |
| cpr_free_prices | freePrices | Short/Boolean | optional | toggle | free prices mode |
| cpr_reverse_calc | reverseCalc | Short/Boolean | optional | toggle | reverse calculation |
| cpr_can_edit_invoice | canEditInvoice | Short/Boolean | optional | role-controlled | invoice edit toggle |
| cpr_comment | comment | String(3000) | optional | editable | comment |
| purchasePurpose.id | purchasePurposeId | Integer | optional | editable | PPS_ID |
| contactPersonSeller.cps_id | sellerContactPersonId | Integer | optional | editable | CPS_ID_SELLER |
| contactPersonCustomer.cps_id | customerContactPersonId | Integer | optional | editable | CPS_ID_CUSTOMER |
| cpr_guaranty_in_month | guarantyInMonth | Integer | optional | editable | guaranty months |
| cpr_prepay_percent | prepayPercent | BigDecimal(15,2) | optional | editable | prepay % |
| cpr_prepay_sum | prepaySum | BigDecimal(15,2) | optional | editable | prepay sum |
| cpr_delay_days | delayDays | Integer | optional | editable | payment delay |
| consignee.id | consigneeId | Integer | optional | editable | CTR_ID_CONSIGNEE |
| cpr_no_reservation | noReservation | Short/Boolean | optional | noReservationReadOnly | no reservation |
| cpr_provider_delivery | providerDelivery | Short/Boolean | optional | toggle | supplier delivery |
| cpr_provider_delivery_address | providerDeliveryAddress | String(500) | optional | editable | supplier delivery address |
| cpr_delivery_count_day | deliveryCountDay | Integer | optional | editable | delivery days |
| cpr_donot_calculate_netto | doNotCalculateNetto | Short/Boolean | optional | toggle | netto switch |
| cpr_print_scale | printScale | Integer | optional | editable | print precision |
| cpr_contract_scale | contractScale | Integer | optional | editable | contract precision |
| cpr_invoice_scale | invoiceScale | Integer | optional | editable | invoice precision |
| cpr_final_date_above | finalDateAbove | Short/Boolean | optional | toggle | final date placement |
| cpr_tender_number | tenderNumber | String(100) | optional | editable if tenderNumberEditable | tender field |
| cpr_tender_number_editable | tenderNumberEditable | Char(1)/Boolean | default '0' | role-controlled | edit guard |
| attachmentId / attachmentsGrid | attachment subsystem | UUID/String + grid | optional | by ACL | deferred attachments |
| gridProduces | produce line collection | list | required for save | editable unless formReadOnly | from `dcl_cpr_list_produce` |
| gridTransport | transport line collection | list | optional | editable unless formReadOnly | from `dcl_cpr_transport` |

## Actions
| Dispatch/Button | New endpoint (target) | Params | Response |
|-----------------|------------------------|--------|----------|
| input/show/edit/back/process | `GET/POST /commercial-proposals/{id}` | id/form payload | HTML redirect/view |
| reload/reloadWithClean/reloadPrice | `POST /commercial-proposals/{id}/reload*` | id + toggles | refreshed form |
| ajaxChangeCourse/ajaxChangeNDS/ajaxChangeCurrency | `POST /commercial-proposals/{id}/calc/*` | id + changed field | JSON + recalculated totals |
| ajaxProducesCommercialProposalGrid | `GET /commercial-proposals/{id}/produces` | id | grid fragment |
| ajaxDeleteAllProduces... / ajaxRemoveFrom... | `DELETE /commercial-proposals/{id}/produces` | id/line id | JSON status |
| ajaxRecalcCommercialProposalGrid/ajaxGetTotal | `POST /commercial-proposals/{id}/recalc` | id + line edits | JSON totals |
| print / printInvoice / printContract | `GET /commercial-proposals/{id}/print?mode=*` | id/mode | printable HTML/PDF |
| generateExcel/importExcel/uploadTemplate | `POST /commercial-proposals/{id}/excel/*` | file/template flags | file download/upload result |
| deferredAttach/deleteAttachment/downloadAttachment | `POST/DELETE/GET /commercial-proposals/{id}/attachments` | attachment id | file/grid update |
| list filter/internalFilter/block/checkPrice/clone/restore | `GET/POST /commercial-proposals` | filter + action params | list page redirect |

## Grids
| Grid ID | Columns | Inline ops | Totals |
|---------|---------|------------|--------|
| ProducesCommercialProposalGrid | product, catalog, price brutto/netto, discount, qty, customs, sale prices | add/edit/remove, recalc, clear all | line & document totals |
| ProducesForAssembleMinskGrid | specific Minsk-store pricing columns | ajax change sale price/remove | custom totals |
| Transport grid (`gridTransport`) | stuff category, transport sum | add/remove rows | sum transport |
| Attachments grid (`attachmentsGrid`) | file name, created by/date | upload/download/delete | N/A |

## Print/Export
| Type | Params | Output format | Parity check |
|------|--------|---------------|--------------|
| Commercial proposal print | cpr_id, include_exps, printMode | HTML/PDF | compare fields + totals |
| Invoice print | cpr_id, printInvoice | HTML/PDF | invoice-specific text/scale |
| Contract print | cpr_id, printContract | HTML/PDF | contract template parity |
| Excel generation/import | templateExcel, cpr_id | XLS/XLSX | line round-trip parity |

## SQL/DAO inventory
- DAO: `CommercialProposalDAO` (`load/insert/save`, produce + transport persistence).
- SQL resources: `commercial_proposal-load`, `commercial_proposal-update*`, `insert_commercial_proposal_produce`, `delete_commercial_proposal_produces`, `select-commercial_proposal_transports`.
- DB schema source: table `DCL_COMMERCIAL_PROPOSAL`, procedure `DCL_COMMERCIAL_PROPOSAL_FILTER`, procedure `DCL_COMMERCIAL_PROPOSAL_INSERT`, indexes `DCL_CPR_IDX_DATE`, `IDX_CPR_CTR`, `IDX_CPR_USR_CREATE`, trigger `DCL_COMMERCIAL_PROPOSAL_BI0`.

## Status: 68/68 mapped for DB/Form core (100% required before cutover)
Open issues: []
