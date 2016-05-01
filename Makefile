all:
	javac -d bin src/*/*.java
	javac -classpath src -d bin src/*.java

clean:
	rm -rf bin/*/*.class
	rm -rf bin/*.class

run:
	java -classpath bin Principal
