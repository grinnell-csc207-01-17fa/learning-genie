import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GuessNode implements DecisionNode {

	public String guess;
	public DecisionNode left;
	public DecisionNode right;
	
	public GuessNode(String guess){
		this.guess = guess;
		this.left = null;
		this.right = null;
	}
	
	public int countObjects() {
		return 0;
	}
	
	public DecisionNode guess(Scanner in) {
		System.out.println("Are you thinking of "+guess+" ?");
		String answer = in.nextLine();
		if(answer.equals("Yes")){
			return this;
		}else {
			System.out.println("Oh no, I was wrong!");
			System.out.println("What animal were you thinking of?");
			String animal = in.nextLine();
			System.out.println("What is a yes/no question that distinguishes a "+guess+" from a "+animal+"?");
			String question = in.nextLine();
			DecisionNode q =(DecisionNode) new QuestionNode(question, new GuessNode(animal), new GuessNode(this.guess));
			return q;
			
			/*
			System.out.println("Oh no, I was wrong!");
			System.out.println("What animal were you thinking of?");
			String animal = in.nextLine();
			System.out.println("What is a yes/no question that distinguishes a Dog from a Cat?");
		*/
		}	
	}
	
	public void write(FileWriter out) throws IOException {
		
		out.write(this.guess);
		
	}
	
}
