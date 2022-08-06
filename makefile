
.DEFAULT_GOAL := compile-run

.PHONY: all test clean

clean:
	rm -Rfv ./out .sources
	find . -type f -name '*.smp','*.swo' -exec rm {} \;

war:
	./mvnw war:war

compile-run: war

