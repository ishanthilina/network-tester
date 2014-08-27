#!/bin/bash


#Client paramemters
URL="72.251.248.20"
PORT="6789"
MAXDELAY="500"
REQUESTINTERVAL="1000"
TIMEOUT="1000"

nohup java -jar ./target/network-tester-client-1.0-SNAPSHOT.jar "$URL" "$PORT" "$MAXDELAY" "$REQUESTINTERVAL" "$TIMEOUT" &
