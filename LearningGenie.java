
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LearningGenie {

	/*
	 * The main method for running the program
	 */
	public static void main(String args[]) throws IOException {
		File data = new File("data.tree");// open file specified
		DecisionTree tree = new DecisionTree(data);// make tree

		Scanner in = new Scanner(System.in);// wait for input
		tree.guess(in);

		FileWriter out = new FileWriter("data.tree");// write out to file
		tree.write(out);
		out.flush();// Flush buffer
		out.close();// Close connection
	}
}
