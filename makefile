all: Money.java Income.java Expense.java FileHandler.java BasicUser.java Menu.java User.java Family.java Main.java
	javac Money.java
	javac Income.java
	javac Expense.java
	javac FileHandler.java
	javac Menu.java
	javac User.java
	javac BasicUser.java
	javac Family.java
	javac Main.java


run: all
	java Main

clean:
	rm -f *.class

jar: all
	jar cfm Project.jar manifest.txt *.class
	java -jar Project.jar                      
