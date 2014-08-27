#!/bin/bash


#Client paramemters
URL="10.1.20.41"
PORT="6789"
MAXDELAY="500"
REQUESTINTERVAL="1000"
TIMEOUT="1000"

java -jar ./target/network-tester-client-1.0-SNAPSHOT.jar "$URL" "$PORT" "$MAXDELAY" "$REQUESTINTERVAL" "$TIMEOUT"