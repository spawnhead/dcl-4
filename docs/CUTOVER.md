# CUTOVER Plan (src -> src_modern)

## Preconditions
- Legacy remains frozen in `src/`.
- Modern stack prepared in `src_modern/`.

## Steps
1. **Backup legacy source**
   - `tar -czf backup-src-legacy.tgz src/`
2. **Migrate DB schema**
   - `mvn flyway:migrate` (or run flyway container from `docker-compose.prod.yml`)
3. **Migrate data**
   - `bash scripts/full_migrate.sh`
4. **Deploy modern app**
   - `java -jar app.jar --spring.profiles.active=modern`
5. **Switch directories**
   - `rm -rf src/`
   - `mv src_modern src/`

## Rollback
- `git revert <cutover-commit>`
- restore `backup-src-legacy.tgz`

## Static checks used in this repo
- Python counts (proc/screen totals)
- `bash -n scripts/full_migrate.sh`
- `docker compose -f docker-compose.prod.yml config`
