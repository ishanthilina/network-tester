#!/bin/bash

##Server Parameters
PORT="6789"
RESPONSEINTERVAL="1000"

nohup java -jar ./target/network-tester-server-1.0-SNAPSHOT.jar "$PORT" "$RESPONSEINTERVAL" &