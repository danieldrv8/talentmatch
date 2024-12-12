#!/bin/sh
host="$1"
shift
until nc -z "$host" 3306; do
  echo "Waiting for MySQL at $host:3306..."
  sleep 1
done
exec "$@"
