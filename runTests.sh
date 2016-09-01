#!/bin/bash

driver=$1
environment=$2
quit=0

if [ -z $driver -a -z $environment ]; then
	environment="prod"
	driver="chrome"
fi

case "$driver" in 
	"chrome")
	;;
	"firefox")
	;;
	"safari")
	;;
	*) echo "$driver is not a valid driver, please use chrome, safari, or firefox."
	quit=1
	;;
esac

case "$environment" in
	"staging") 
	;;
	"prod") environment="www"
	;;
	*) echo "$environment is not a valid environment, please use prod or staging"
	quit=1
	;;
esac

if [ $quit -eq 1 ]; then
	exit
fi

mvn clean verify -Dwebdriver.driver="$driver" -Denv="$environment" 
open target/site/serenity/index.html 
