.DEFAULT_GOAL := compile-run

.PHONY: all test clean              # A phony target is one that is not really the name of a file; rather it is just a name for a recipe to be executed when you make an explicit request.

look:
	lsof -i:8080

clean:
	rm -Rfv ./out ./bin .sources
	find . -type f -name "*.swp" -exec rm {} \;

compile:
	find ./src -not -type d | grep \\.java$  > .sources
	javac -d out/ -cp .:lib/* -sourcepath src/main/ @.sources

copy-resources:
	cp ./src/main/resources/* ./out

jar:
	@if [ ! -d "./bin" ]; then\
		mkdir bin;\
	fi
	jar cvfe bin/App.jar App -C out/ .

run:
	java -cp .:out/:lib/* App

run-jar:
	java -cp .:lib/*:bin/* App

compile-run: clean compile run

