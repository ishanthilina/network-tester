@echo off 
set URL=10.1.20.41
set PORT=7689
set MAXDELAY=500
set REQUESTINTERVAL=1000
set TIMEOUT=1000


java -jar ./target/network-tester-client-1.0-SNAPSHOT.jar %URL% %PORT% %MAXDELAY% %REQUESTINTERVAL% %TIMEOUT%