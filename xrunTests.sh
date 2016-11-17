#!/bin/bash
#!/bin/bash

driver=$1

if [ -z $1 ]; then
    driver="chrome"
fi


sudo su
Xvfb -ac :99 -screen 0 1280x768x24 &
export DISPLAY=:99
mvn clean verify -Dwebdriver.driver=$driver
killall Xvfb
open target/site/serenity/index.html
exit
