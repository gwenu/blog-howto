#!/bin/bash

set -e

BACKUP_NAME=$(date +%y%m%d_%H%M%S).gz

date
echo "Backing up MongoDB database"

echo "Dumping MongoDB modelDb database to compressed archive: $BACKUP_NAME"
mongodump --port 27019 --db modelDb --archive=/data/db/backups/$BACKUP_NAME --gzip >> /data/db/backups/logs

echo 'Backup completed successfully!'