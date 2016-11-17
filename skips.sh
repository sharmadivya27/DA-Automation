#!/bin/bash

action=$1
stories="src/test/resources/stories/fullRegression"

if [ $# == 0 ]; then
	echo "Please enter rm or add"
fi

case "$action" in
	"add")
		sed -i '' "s/Meta:*/Meta: @skip/g" "$stories"/regressionChecklist.story
		sed -i '' "s/Meta:*/Meta: @skip/g" "$stories"/regressionChecklistSpanish.story
		;;
	"rm")
		sed -i '' "s/@skip//g" "$stories"/regressionChecklist.story
		sed -i '' "s/@skip//g" "$stories"/regressionChecklistSpanish.story
		;;
	*)
		echo "Please enter rm or add"
		;;
esac
