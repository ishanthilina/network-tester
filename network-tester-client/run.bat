@echo off 
set URL=10.1.20.41
set PORT=7689


java -jar ./target/network-tester-client-1.0-SNAPSHOT.jar %URL% %PORT%