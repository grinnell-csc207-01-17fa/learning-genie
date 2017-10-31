import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LearningGenie {

	public static void main(String args[]) throws IOException{
		File data = new File("data.txt");
		DecisionTree tree = new DecisionTree(data);
		
        Scanner in = new Scanner(System.in);
		tree.guess(in);
		
		FileWriter out = new FileWriter("out.txt");
		tree.write(out);
		out.close();
	}
}
