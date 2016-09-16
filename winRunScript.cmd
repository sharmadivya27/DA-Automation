@echo off
SETLOCAL
SET driver=chrome
SET env=prod

mvn clean verify -Dwebdriver.driver=%driver% -Denv=%env%
