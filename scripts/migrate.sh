#!/usr/bin/env bash
set -euo pipefail

FIREBIRD_DB=${FIREBIRD_DB:-/data/dcl.fdb}
FIREBIRD_BAK=${FIREBIRD_BAK:-/data/dcl.fbk}

if command -v gbak >/dev/null 2>&1; then
  gbak -b -user SYSDBA -password masterkey "$FIREBIRD_DB" "$FIREBIRD_BAK"
else
  echo "gbak not found, skipping backup step"
fi

mvn -DskipTests flyway:migrate

if command -v pgloader >/dev/null 2>&1; then
  echo "Run pgloader with your project-specific .load file"
else
  echo "pgloader not found; use CSV export/import fallback"
fi
