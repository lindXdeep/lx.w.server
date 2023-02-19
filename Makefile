.DEFAULT_GOAL := compile-run

.PHONY := all test clear kill

compile:
	find ./src -not -type d | grep \\.java$ > .sources
	javac -d out/ -sourcepath src/main/ @.sources

run:
	java -cp .:out/ App

compile-run: compile run

