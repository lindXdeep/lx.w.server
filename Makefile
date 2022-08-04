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
	@if [ -f bin/App.jar ]; then\
		java -cp .:lib/*:bin/* App;\
	else\
		java -cp .:out/:lib/* App;\
	fi

assembly:
	mvn compile assembly:single

run-assembly:
	java -jar target/server.jar


compile-run: clean compile run

