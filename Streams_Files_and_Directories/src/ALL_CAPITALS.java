import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ALL_CAPITALS {

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Milen\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
		FileReader fr = new FileReader(path);
		BufferedReader reader = new BufferedReader(fr);
		PrintWriter writer = new PrintWriter("C:\\Users\\Milen\\Desktop\\output.txt");

		String line = reader.readLine();

		while (line != null) {

			writer.println(line.toUpperCase());
			writer.flush();
			line = reader.readLine();
		}
		reader.close();
		writer.close();

	}

}
