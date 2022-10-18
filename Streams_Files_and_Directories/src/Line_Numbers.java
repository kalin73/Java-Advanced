import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Line_Numbers {

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Milen\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
		FileReader fr = new FileReader(path);
		BufferedReader reader = new BufferedReader(fr);
		PrintWriter writer = new PrintWriter("C:\\Users\\Milen\\Desktop\\output.txt");
		int n = 1;
		String line = reader.readLine();

		while (line != null) {

			writer.write(n + ". " + line + "\n");
			n++;
			line = reader.readLine();
		}
		writer.flush();
		reader.close();
		writer.close();
	}

}
