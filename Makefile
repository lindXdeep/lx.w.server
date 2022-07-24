.DEFAULT_GOAL := compile-run

.PHONY: all test clean              # A phony target is one that is not really the name of a file; rather it is just a name for a recipe to be executed when you make an explicit request.

clear:
	rm -Rfv ./out .sources
	find . -type f -name "*.swp" -exec rm {} \;

compile:
	find ./src -not -type d | grep \\.java$  > .sources
	javac -d out/ -cp .:lib/javax.servlet-api-4.0.1.jar:lib/jetty-all-9.4.48.v20220622-uber.jar -sourcepath src/ @.sources

copy-resources:
	cp ./src/main/resources/* ./out

run:
	java -cp .:out/:lib/javax.servlet-api-4.0.1.jar:lib/jetty-all-9.4.48.v20220622-uber.jar App

compile-run: compile run

