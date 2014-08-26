#!/bin/bash


#Client paramemters
URL="10.1.20.41"
PORT="6789"

java -jar ./target/network-tester-client-1.0-SNAPSHOT.jar "$URL" "$PORT"