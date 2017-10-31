package non;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public interface DecisionNode {
	//these are all the methods for the GuessNode.java and QuestionNode.java
	
	/**
	 * Count the number of objects from the current Node.
	 * @param none
	 */
	public int countObjects();
	
	/**
	 * Perform guess from the current Node.
	 * @param in, the user input from terminal
	 */
	public DecisionNode guess(Scanner in);
	
	/**
	 * Write out to file recursively
	 * @param out, the File that is going to be written
	 */
	public void write(FileWriter out) throws IOException;
		
}
