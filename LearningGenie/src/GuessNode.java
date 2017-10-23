import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GuessNode implements DecisionNode {

	public String guess;
	public DecisionNode left;
	public DecisionNode right;
	
	public int countObjects() {
		
	}
	
	public DecisionNode guess(Scanner in) {
		
		
	}
	
	public void write(FileWriter out) throws IOException {
		
		out.write(this.guess);
		
	}
	
}
