
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GuessNode implements DecisionNode {

	private String guess;
	private DecisionNode left;
	private DecisionNode right;
	
	/**
	 * Constructs QGuessNode
	 * @param guess, the String form of the object
	 */
	public GuessNode(String guess){
		this.guess = guess;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Count the number of objects from the current Node
	 * @param none
	 */
	public int countObjects() {
		return 1;
	}

	/**
	 * Perform guess from the current Node
	 * @param in, the user input from terminal
	 */
	public DecisionNode guess(Scanner in) {
		while(true) {//Infinite Loop
			System.out.print("Are you thinking of "+guess+"? ");
			String answer = in.nextLine().toLowerCase();//Case In-Sensitive
			if(answer.equals("yes")){
				System.out.println("Excellent, thanks!");
				return this;
			}else if(answer.equals("no")){
				System.out.println("Oh no, I was wrong!");
				System.out.print("What animal were you thinking of? ");
				String animal;
				//Gathering info and checking input
				while(true) {
					animal = in.nextLine();
					if(!animal.startsWith("#")) break;
					System.out.print("Name cannot start with #, reenter! ");
				}

				System.out.println("What is a yes/no question that distinguishes a "+guess+" from a "+animal+"? ");
				System.out.print("(Yes corresponds to "+guess+"; No corresponds to "+animal+")");

				String question;
				//Question gathering
				while(true) {
					question = in.nextLine();
					if(!question.startsWith("#")) break;
					System.out.print("Question cannot start with #, reenter!");
				}

				QuestionNode q = new QuestionNode(question, new GuessNode(this.guess),new GuessNode(animal));
				System.out.println("Thanks! I'll learn from this experience!");	
				return q;
			}	
		}
	}
	
	/**
	 * Write out to file recursively
	 * @param out, the File that is going to be written
	 */
	public void write(FileWriter out) throws IOException {
		out.write(this.guess + "\n");

	}

}
