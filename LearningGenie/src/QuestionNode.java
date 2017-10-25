import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuestionNode {

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
		return guessNodes;
	}
	
	public DecisionNode guess(Scanner in) {
		System.out.println(question);
		String answer = in.nextLine();
		if(answer.equals("Yes")){
			if(this.left instanceof GuessNode){
				DecisionNode left = this.left.guess(in);
				this.left = left;
				return left;
			}else{
				return this.left.guess(in);
			}
		}else {
			if(this.right instanceof GuessNode){
				DecisionNode right = this.right.guess(in);
				this.right = right;
				return right;
			}else{
				return this.right.guess(in);
			}
			/*
			System.out.println("Oh no, I was wrong!");
			System.out.println("What animal were you thinking of?");
			String animal = in.nextLine();
			System.out.println("What is a yes/no question that distinguishes a Dog from a Cat?");
		*/
		}
		/*
		System.out.println("Are you thinking of "+);
		String answer = in.nextLine();
		if
		*/	
	}
	
	public void write(FileWriter out) throws IOException {
		
		out.write("#"+this.question);
		
	}
	
}
