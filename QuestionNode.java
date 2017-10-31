package non;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuestionNode implements DecisionNode{
	//Bunch o' variable declarations
	public String question;
	public DecisionNode left;
	public DecisionNode right;
	public int guessNodes;


	/**
	 * Constructs a QuestionNode
	 * @param question, the String form of the question
	 * @param left, a DecisionNode represents yes
	 * @param right, a DecisionNode represents no
	 */
	public QuestionNode(String question, DecisionNode left, DecisionNode right){
		this.question = question;
		this.left = left;
		this.right = right;
	}

	/**
	 * Count the number of objects from the current Node
	 * @param none
	 */
	public int countObjects() {
		return this.left.countObjects() + this.right.countObjects();
	}

	/**
	 * Perform guess from the current Node
	 * @param in, the user input from terminal
	 */
	public DecisionNode guess(Scanner in) {
		System.out.print(question);
		while(true) {
			String answer = in.nextLine().toLowerCase();//Case In-sensitive
			if(answer.equals("yes")){//Logic for yes no response
				DecisionNode left = this.left.guess(in);
				this.left = left;
				return this;
			}else if(answer.equals("no")){
				DecisionNode right = this.right.guess(in);
				this.right = right;
				return this;
			}else {
				System.out.print("You must enter yes or no! Reenter!");//Input check
			}
		}

	}

	/**
	 * Write out to file recursively
	 * @param out, the File that is going to be written
	 */
	public void write(FileWriter out) throws IOException {	
		out.write("#"+this.question + "\n");
		this.left.write(out);
		this.right.write(out);
	}

}
