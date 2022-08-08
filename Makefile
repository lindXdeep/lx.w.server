.DEFAULT_GOAL := compile-run

.PHONY: all test clean              # A phony target is one that is not really the name of a file; rather it is just a name for a recipe to be executed when you make an explicit request.

clear:
	rm -Rfv ./out .sources
	find . -type f -name "*.swp" -exec rm {} \;
	find . -type f -name "*.swo" -exec rm {} \;

compile:
	find ./src -not -type d | grep \\.java$  > .sources
	javac -d out/ -cp .:lib/* -sourcepath src/ @.sources

run:
	java -cp .:out/:lib/* App

compile-run: clear compile run

