echo off
set PORT=7689
set RESPONSEINTERVAL=1000

java -jar ./target/network-tester-server-1.0-SNAPSHOT.jar %PORT% %RESPONSEINTERVAL%