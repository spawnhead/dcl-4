#!/usr/bin/env bash
set -euo pipefail

# DCL full migration helper (NO Maven required).
# Flow: Firebird backup restore/export -> CSV staging -> PostgreSQL bulk load.

FB_DB_PATH="${FB_DB_PATH:-/data/LINTERA.FDB}"
FB_GBAK="${FB_GBAK:-gbak}"
FB_ISQL="${FB_ISQL:-isql-fb}"
PG_URL="${PG_URL:-postgresql://dcl:dcl@localhost:5432/dcl}"
WORK_DIR="${WORK_DIR:-/tmp/dcl_migrate}"
SAMPLE_ONLY="${SAMPLE_ONLY:-0}"

mkdir -p "$WORK_DIR/csv"

echo "[1/6] Firebird metadata sanity check"
$FB_ISQL "$FB_DB_PATH" -q <<'SQL'
set list on;
select count(*) as TABLES_CNT from rdb$relations where coalesce(rdb$system_flag,0)=0;
SQL

echo "[2/6] Export key tables to CSV (template; replace SELECT list per table)"
cat > "$WORK_DIR/export_fb.sql" <<'SQL'
-- Example exports. Replace with fbexport/bcp tool commands available in your environment.
-- select * from DCL_COMMERCIAL_PROPOSAL;
-- select * from DCL_ORDER;
-- select * from DCL_USER;
SQL

echo "[3/6] Prepare PostgreSQL staging schema"
psql "$PG_URL" -v ON_ERROR_STOP=1 <<'SQL'
create schema if not exists staging;
SQL

echo "[4/6] Bulk load CSV files"
for f in "$WORK_DIR"/csv/*.csv; do
  [ -e "$f" ] || continue
  t=$(basename "$f" .csv)
  echo "Loading $f -> staging.$t"
  psql "$PG_URL" -v ON_ERROR_STOP=1 -c "\\copy staging.$t from '$f' csv header"
done

echo "[5/6] Merge staging into target tables (template)"
psql "$PG_URL" -v ON_ERROR_STOP=1 <<'SQL'
-- insert into dcl_commercial_proposal(...) select ... from staging.dcl_commercial_proposal;
-- insert into dcl_order(...) select ... from staging.dcl_order;
SQL

echo "[6/6] Seed verification sample (10 rows commercial proposal)"
psql "$PG_URL" -v ON_ERROR_STOP=1 <<'SQL'
insert into dcl_commercial_proposal (
  cpr_create_date, usr_id_create, cpr_edit_date, usr_id_edit, cpr_number, cpr_date, ctr_id, cur_id,
  trm_id_price_condition, trm_id_delivery_condition, cur_id_table, bln_id, cpr_tender_number_editable, cpr_proposal_declined
)
select now(), 1, now(), 1, 'CPR-SAMPLE-'||g::text, current_date-g, 1, 1, 1, 1, 1, 1, '0', '0'
from generate_series(1,10) g
on conflict do nothing;
SQL

echo "Done."
