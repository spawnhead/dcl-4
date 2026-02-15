# DCL-4 Data Migration (Firebird -> Postgres)

## 1) Backup Firebird
```bash
gbak -b -user SYSDBA -password masterkey /path/to/db.fdb /path/to/dump.fbk
```

## 2) Prepare Postgres schema
```bash
mvn -DskipTests flyway:migrate
```

## 3) Migrate data
Preferred path:
```bash
pgloader /path/to/firebird.load
```

Alternative staged path:
1. Export Firebird tables to CSV.
2. Use `psql \copy` into Postgres staging tables.
3. Run normalization SQL scripts.

## 4) Validate
- Row counts for key tables (`dcl_commercial_proposal`, `dcl_contract`, `dcl_order`).
- Check checksum samples and business totals.

## 5) Cutover checklist
- Freeze writes in legacy.
- Run final delta export/import.
- Re-run smoke checks by parity maps.
