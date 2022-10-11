import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Write_Every_Third_Line {

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Milen\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
		String path2 = "C:\\Users\\Milen\\Desktop\\3rdLines.txt";
		FileReader inpReader = new FileReader(path);
		BufferedReader reader = new BufferedReader(inpReader);
		PrintStream writer = new PrintStream(path2);
		int count = 1;

		String line = reader.readLine();
		while (line != null) {

			if (count % 3 == 0) {

				writer.println(line);

			}
			line = reader.readLine();
			count++;
		}
		reader.close();
		writer.close();
	}

}
