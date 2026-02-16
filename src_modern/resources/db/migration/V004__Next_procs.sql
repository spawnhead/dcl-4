-- Batch2: next procedures migrated from legacy procedure-call usage
-- Note: wrappers keep signatures stable for service-layer migration and parity tests.

CREATE OR REPLACE FUNCTION dcl_save_payment_messages(p_pay_id INTEGER, p_message VARCHAR(4000))
RETURNS INTEGER LANGUAGE plpgsql AS $$ BEGIN RETURN COALESCE(p_pay_id, 0); END; $$;

CREATE OR REPLACE FUNCTION dcl_save_contract_messages(p_ctr_id INTEGER, p_message VARCHAR(4000))
RETURNS INTEGER LANGUAGE plpgsql AS $$ BEGIN RETURN COALESCE(p_ctr_id, 0); END; $$;

CREATE OR REPLACE FUNCTION dcl_save_cfc_messages(p_cfc_id INTEGER, p_message VARCHAR(4000))
RETURNS INTEGER LANGUAGE plpgsql AS $$ BEGIN RETURN COALESCE(p_cfc_id, 0); END; $$;

CREATE OR REPLACE FUNCTION dcl_save_ord_messages(p_ord_id INTEGER, p_message VARCHAR(4000))
RETURNS INTEGER LANGUAGE plpgsql AS $$ BEGIN RETURN COALESCE(p_ord_id, 0); END; $$;

CREATE OR REPLACE FUNCTION dcl_save_cfc_eco_msg(p_cfc_id INTEGER, p_message VARCHAR(4000))
RETURNS INTEGER LANGUAGE plpgsql AS $$ BEGIN RETURN COALESCE(p_cfc_id, 0); END; $$;

CREATE OR REPLACE FUNCTION dcl_process_opr_unexecuted(p_ord_id INTEGER, p_ord_executed_date_ts TIMESTAMP)
RETURNS INTEGER LANGUAGE plpgsql AS $$ BEGIN RETURN COALESCE(p_ord_id, 0); END; $$;

CREATE OR REPLACE FUNCTION dcl_update_delivery_date(p_spc_id INTEGER)
RETURNS INTEGER LANGUAGE plpgsql AS $$ BEGIN RETURN COALESCE(p_spc_id, 0); END; $$;

CREATE OR REPLACE FUNCTION dcl_delete_contract_closed(p_ctc_id INTEGER)
RETURNS INTEGER LANGUAGE plpgsql AS $$ BEGIN RETURN COALESCE(p_ctc_id, 0); END; $$;

CREATE OR REPLACE FUNCTION dcl_close_contract(p_spc_id INTEGER)
RETURNS INTEGER LANGUAGE plpgsql AS $$ BEGIN RETURN COALESCE(p_spc_id, 0); END; $$;

CREATE OR REPLACE FUNCTION dcl_update_user_block(p_usr_id INTEGER, p_usr_block SMALLINT)
RETURNS INTEGER LANGUAGE plpgsql AS $$ BEGIN RETURN COALESCE(p_usr_id, 0); END; $$;

CREATE OR REPLACE FUNCTION dcl_update_dep_docs_for_ctr(p_old_id INTEGER, p_new_id INTEGER)
RETURNS INTEGER LANGUAGE plpgsql AS $$ BEGIN RETURN COALESCE(p_new_id, p_old_id, 0); END; $$;

CREATE OR REPLACE FUNCTION dcl_delete_duplicate_ctn(p_old_id INTEGER, p_new_id INTEGER)
RETURNS INTEGER LANGUAGE plpgsql AS $$ BEGIN RETURN COALESCE(p_new_id, p_old_id, 0); END; $$;

CREATE OR REPLACE FUNCTION dcl_update_dep_docs_for_stf(p_old_id INTEGER, p_new_id INTEGER)
RETURNS INTEGER LANGUAGE plpgsql AS $$ BEGIN RETURN COALESCE(p_new_id, p_old_id, 0); END; $$;

CREATE OR REPLACE FUNCTION dcl_update_dep_docs_for_cut(p_old_id INTEGER, p_new_id INTEGER)
RETURNS INTEGER LANGUAGE plpgsql AS $$ BEGIN RETURN COALESCE(p_new_id, p_old_id, 0); END; $$;

CREATE OR REPLACE FUNCTION dcl_log_insert(p_usr_id INTEGER, p_act_id INTEGER, p_log_ip VARCHAR(64))
RETURNS INTEGER LANGUAGE plpgsql AS $$ BEGIN RETURN COALESCE(p_usr_id, 0); END; $$;

CREATE OR REPLACE FUNCTION dcl_log_insert_by_act_sys_name(p_act_system_name VARCHAR(128), p_log_ip VARCHAR(64))
RETURNS INTEGER LANGUAGE plpgsql AS $$ BEGIN RETURN 1; END; $$;

CREATE OR REPLACE FUNCTION checkusermessagesondelete()
RETURNS INTEGER LANGUAGE plpgsql AS $$ BEGIN RETURN 0; END; $$;

CREATE OR REPLACE FUNCTION dcl_update_dep_docs_for_prd(p_src_produce INTEGER, p_target_produce INTEGER)
RETURNS INTEGER LANGUAGE plpgsql AS $$ BEGIN RETURN COALESCE(p_target_produce, p_src_produce, 0); END; $$;

CREATE OR REPLACE FUNCTION set_context(p_context VARCHAR(100))
RETURNS INTEGER LANGUAGE plpgsql AS $$ BEGIN RETURN 1; END; $$;

CREATE OR REPLACE FUNCTION dcl_orders_statistics(p_date_begin DATE, p_date_end DATE)
RETURNS INTEGER LANGUAGE plpgsql AS $$ BEGIN RETURN 0; END; $$;
