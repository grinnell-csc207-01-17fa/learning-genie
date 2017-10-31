import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuestionNode implements DecisionNode{

	public String question;
	public DecisionNode left;
	public DecisionNode right;
	public int guessNodes;

	public QuestionNode(String question, DecisionNode left, DecisionNode right){
		this.question = question;
		this.left = left;
		this.right = right;
	}

	public int countObjects() {
		return this.left.countObjects() + this.right.countObjects();
	}

	public DecisionNode guess(Scanner in) {
		System.out.print(question);
		while(true) {
			String answer = in.nextLine().toLowerCase();
			if(answer.equals("yes")){
				DecisionNode left = this.left.guess(in);
				this.left = left;
				return this;
			}else if(answer.equals("no")){
				DecisionNode right = this.right.guess(in);
				this.right = right;
				return this;
			}else {
				System.out.print("You must enter yes or no! Reenter!");
			}
		}

	}

	public void write(FileWriter out) throws IOException {	
		out.write("#"+this.question);
		this.left.write(out);
		this.right.write(out);
	}

}
