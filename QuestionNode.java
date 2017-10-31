import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuestionNode implements DecisionNode{
    //Bunch o' variable declarations
	public String question;
	public DecisionNode left;
	public DecisionNode right;
	public int guessNodes;
	//Constructor
	public QuestionNode(String question, DecisionNode left, DecisionNode right){
		this.question = question;
		this.left = left;
		this.right = right;
	}
	//Get a count of object viewable/known by the program.
	public int countObjects() {
		return this.left.countObjects() + this.right.countObjects();
	}

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
	//Write out to file recursively
	public void write(FileWriter out) throws IOException {	
		out.write("#"+this.question + "\n");
		this.left.write(out);
		this.right.write(out);
	}

}
