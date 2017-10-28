import java.io.FileWriter;
import java.util.Scanner;

public class DecisionTree {
	public DecisionNode root;

	public DecisionTree(){
		this.root = new GuessNode("Dog");
	}

	public int countObjects(){
		return root.countObjects();
	}

	public void guess(Scanner in){
		this.root.guess(in);	
	}

	public void write(FileWriter out){

	}

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		DecisionTree tree = new DecisionTree();
		DecisionNode cur = tree.root;

		System.out.println("I am the learning genie!");
		System.out.println("I can figure out whatever you are thinking of by asking questions.");
		System.out.println("I know " + tree.root.countObjects() + " thing! \n");

		while(true){
			System.out.println("Think of an object!");
			tree.root = cur.guess(in);
			System.out.print("Do you want to continue?");
			String ifContinue = in.nextLine();
			if(ifContinue.equals("Yes")){
				if(cur instanceof GuessNode){
					cur = tree.root;
				}else if(cur instanceof QuestionNode){
					cur.guess(in);
				}
			}else if(ifContinue.equals("No")){
                break;
			}
		}
	}

}
