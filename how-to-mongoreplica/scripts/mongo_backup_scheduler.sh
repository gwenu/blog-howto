#!/bin/bash

apt-get update
apt-get install nano
apt-get install cron

# Start cron service
service cron start

mkdir -p /data/db/backups
touch /data/db/backups/logs
touch /var/spool/cron/crontabs/root

# Everyday at 1 a.m.
CRON_COMMAND="00 01 * * * /bin/bash /scripts/mongo_backup.sh > /data/db/backups/logs"

crontab -l | grep -F -q "$CRON_COMMAND" && echo 'Backup has already been scheduled.' || echo 'Scheduling new backup cron job for mongodb.' && crontab -l | { cat; echo "$CRON_COMMAND"; } | crontab -

echo "Joining mongodb replica set: mongo-replica"
mongod --port 27017 --bind_ip_all --replSet mongo-replica