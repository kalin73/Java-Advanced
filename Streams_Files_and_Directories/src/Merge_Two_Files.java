import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Merge_Two_Files {

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Kalin\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
		String path2 = "C:\\Users\\Kalin\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";

		FileReader inp = new FileReader(path);
		FileReader inp2 = new FileReader(path2);

		BufferedReader reader = new BufferedReader(inp);
		BufferedReader reader2 = new BufferedReader(inp2);

		PrintWriter writer = new PrintWriter("C:\\Users\\Kalin\\Desktop\\result.txt");

		String line = reader.readLine();

		while (line != null) {

			writer.println(line);
			line = reader.readLine();

		}
		line = reader2.readLine();

		while (line != null) {

			writer.println(line);
			line = reader2.readLine();

		}
		writer.flush();
		reader.close();
		reader2.close();
		writer.close();
	}

}
