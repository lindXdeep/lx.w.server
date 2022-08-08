.DEFAULT_GOAL := compile-run

.PHONY: all clean test

clean:
	rm -Rfv ./out .sources
	find . -type f -name "*.swp" -exec rm {} \;
	find . -type f -name "*.swo" -exec rm {} \;

compile:
	find ./src -not -type d | grep \\.java$ > .sources
	javac -d out/ -cp .:lib/* -sourcepath src/ @.sources

run:
	java -cp .:out/:lib/* App

compile-run: clean compile run

