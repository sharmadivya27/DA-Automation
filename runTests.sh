#!/bin/bash

driver=$1
env=$2
quit=0

if [ -z $driver -a -z $env ]; then
	env="prod"
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

case "$env" in
	"staging") 
	;;
	"prod") env="www"
	;;
	"testint")
	;;
	*) echo "$env is not a valid environment, please use prod, staging, or testint"
	quit=1
	;;
esac

if [ $quit -eq 1 ]; then
	exit
fi

mvn clean verify -Dwebdriver.driver="$driver" -Denv="$env" 
open target/site/serenity/index.html 
