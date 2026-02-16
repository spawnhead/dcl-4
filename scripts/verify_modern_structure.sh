#!/usr/bin/env bash
# Проверка структуры modern-модуля: подсчёт артефактов и отсутствие legacy-пакетов.
set -euo pipefail
MODERN_DIR="${1:-modern}"
echo "=== Verify $MODERN_DIR ==="
CONTROLLERS=$(find "$MODERN_DIR/src/main/java" -name '*Controller.java' 2>/dev/null | wc -l)
TEMPLATES=$(find "$MODERN_DIR/src/main/resources/templates" -name '*.html' 2>/dev/null | wc -l)
MIGRATIONS=$(find "$MODERN_DIR/src/main/resources/db/migration" -name '*.sql' 2>/dev/null | wc -l)
echo "Controllers: $CONTROLLERS (expected 163)"
echo "Templates:   $TEMPLATES (expected 163)"
echo "Flyway migrations: $MIGRATIONS (expected 10)"
LEGACY_HITS=$(rg -l 'net\.sam\.dcl\.config\b' "$MODERN_DIR/src" --glob '*.java' 2>/dev/null | wc -l) || true
if [ "${LEGACY_HITS:-0}" -gt 0 ]; then
  echo "FAIL: found $LEGACY_HITS file(s) with legacy package net.sam.dcl.config in $MODERN_DIR"
  exit 1
fi
echo "Legacy package check: OK (no net.sam.dcl.config in modern)"
echo "Done."
