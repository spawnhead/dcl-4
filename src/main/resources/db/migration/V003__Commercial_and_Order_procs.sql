-- Priority business procedures migrated from Firebird to PostgreSQL
-- Scope: Commercial Proposal + Orders (first parity batch)

CREATE OR REPLACE FUNCTION dcl_commercial_proposal_insert(
    p_cpr_date DATE,
    p_ctr_id INTEGER,
    p_cur_id INTEGER,
    p_trm_id_price_condition INTEGER,
    p_trm_id_delivery_condition INTEGER,
    p_bln_id INTEGER,
    p_usr_id INTEGER,
    p_cpr_number VARCHAR(20)
) RETURNS INTEGER
LANGUAGE plpgsql
AS $$
DECLARE
    v_id INTEGER;
BEGIN
    INSERT INTO dcl_commercial_proposal (
        cpr_create_date,
        usr_id_create,
        cpr_edit_date,
        usr_id_edit,
        cpr_number,
        cpr_date,
        ctr_id,
        cur_id,
        trm_id_price_condition,
        trm_id_delivery_condition,
        bln_id,
        cur_id_table,
        cpr_proposal_received_flag,
        cpr_tender_number_editable,
        cpr_proposal_declined
    ) VALUES (
        CURRENT_TIMESTAMP,
        p_usr_id,
        CURRENT_TIMESTAMP,
        p_usr_id,
        p_cpr_number,
        p_cpr_date,
        p_ctr_id,
        p_cur_id,
        p_trm_id_price_condition,
        p_trm_id_delivery_condition,
        p_bln_id,
        p_cur_id,
        0,
        '0',
        '0'
    ) RETURNING cpr_id INTO v_id;

    RETURN v_id;
END;
$$;

CREATE OR REPLACE FUNCTION dcl_commercial_proposal_filter(
    p_cpr_number_in VARCHAR(20) DEFAULT NULL,
    p_ctr_id_in INTEGER DEFAULT NULL,
    p_date_begin DATE DEFAULT NULL,
    p_date_end DATE DEFAULT NULL
) RETURNS TABLE (
    cpr_id INTEGER,
    cpr_number VARCHAR(20),
    cpr_date DATE,
    ctr_id INTEGER,
    cpr_block SMALLINT,
    cpr_proposal_received_flag SMALLINT
)
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY
    SELECT c.cpr_id, c.cpr_number, c.cpr_date, c.ctr_id, c.cpr_block, c.cpr_proposal_received_flag
    FROM dcl_commercial_proposal c
    WHERE (p_cpr_number_in IS NULL OR c.cpr_number ILIKE '%' || p_cpr_number_in || '%')
      AND (p_ctr_id_in IS NULL OR c.ctr_id = p_ctr_id_in)
      AND (p_date_begin IS NULL OR c.cpr_date >= p_date_begin)
      AND (p_date_end IS NULL OR c.cpr_date <= p_date_end)
    ORDER BY c.cpr_date DESC, c.cpr_id DESC;
END;
$$;

CREATE OR REPLACE FUNCTION dcl_order_filter(
    p_ord_number_in VARCHAR(50) DEFAULT NULL,
    p_date_begin DATE DEFAULT NULL,
    p_date_end DATE DEFAULT NULL
) RETURNS TABLE (
    ord_id INTEGER,
    ord_number VARCHAR(50),
    ord_date DATE,
    ctr_id INTEGER,
    ord_block SMALLINT
)
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY
    SELECT o.ord_id, o.ord_number, o.ord_date, o.ctr_id, o.ord_block
    FROM dcl_order o
    WHERE (p_ord_number_in IS NULL OR o.ord_number ILIKE '%' || p_ord_number_in || '%')
      AND (p_date_begin IS NULL OR o.ord_date >= p_date_begin)
      AND (p_date_end IS NULL OR o.ord_date <= p_date_end)
    ORDER BY o.ord_date DESC, o.ord_id DESC;
END;
$$;

CREATE OR REPLACE FUNCTION dcl_close_reserved_in_cpr()
RETURNS INTEGER
LANGUAGE plpgsql
AS $$
DECLARE
    v_count INTEGER;
BEGIN
    UPDATE dcl_commercial_proposal
    SET cpr_block = 1,
        cpr_no_reservation = 1,
        cpr_edit_date = CURRENT_TIMESTAMP
    WHERE cpr_proposal_received_flag = 0
      AND cpr_no_reservation IS DISTINCT FROM 1;

    GET DIAGNOSTICS v_count = ROW_COUNT;
    RETURN v_count;
END;
$$;
