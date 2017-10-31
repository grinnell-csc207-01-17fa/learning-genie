package non;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DecisionTree {
	public DecisionNode root;


	/**
	 * Constructs a new Decision Tree with Dog as the Root
	 * @param none
	 */
	public DecisionTree(){
		this.root = new GuessNode("Dog");
	}


	/**
	 * Constructs a tree from the given input.
	 * @param Scanner in, the input stream
	 */
	public DecisionNode makeTree(Scanner in) {	
		if(in.hasNextLine()) {
			String next = in.nextLine();
			if(next.startsWith("#")) {
				return new QuestionNode(next.substring(1, next.length()),
						makeTree(in),makeTree(in));

			}else{
				return new GuessNode(next);
			}

		}else {
			return null;
		}
	}


	/**
	 * Constructs a new Tree from the given file
	 * @param file, a File object
	 */
	public DecisionTree(File file) throws FileNotFoundException {
		Scanner inTree = new Scanner(file);

		//Check for empty file
		if(!inTree.hasNextLine()) {
			System.out.println("Empty File!");
		}

		this.root = makeTree(inTree);
	}


	/**
	 * Return the count of GuessNode in the tree.
	 * @param none
	 */
	public int countObjects(){
		return this.root.countObjects();
	}


	/**
	 * Perform the guess from the beginning
	 * @param in, the terminal that reads user inputs
	 */
	public void guess(Scanner in){
		System.out.println("I am the learning genie!");
		System.out.println("I can figure out whatever you are thinking of by asking questions.");
		System.out.println("I know " + root.countObjects() + " thing(s)! \n");


		while(true){
			System.out.println("Think of an object! ");
			//if(root instanceof QuestionNode)System.out.println(((QuestionNode) root).question);
			root = root.guess(in);
			System.out.print("Do you want to continue? ");
			String ifContinue;
			while(true) {
				ifContinue = in.nextLine().toLowerCase();
				if(ifContinue.equals("no")){
					break;
				}else if(ifContinue.equals("yes")){
					break;
				}else {
					System.out.print("Please enter yes or no! Reenter: ");
				}
			}
			if(ifContinue.equals("no")){
				break;
			}else if(ifContinue.equals("yes")){
				System.out.println();
				continue;
			}
		}
	}

	/**
	 * Write out to file recursively
	 * @param out, the File that is going to be written
	 */
	public void write(FileWriter out) throws IOException{
		this.root.write(out);		
	}


}
