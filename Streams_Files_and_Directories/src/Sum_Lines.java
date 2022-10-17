import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sum_Lines {

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Milen\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
		FileReader inpReader = new FileReader(path);
		BufferedReader reader = new BufferedReader(inpReader);
		String line = reader.readLine();

		while (line != null) {
			int sum = 0;
			for (int i = 0; i < line.length(); i++) {
				int charVal = line.charAt(i);
				sum += charVal;
			}
			System.out.println(sum);
			line = reader.readLine();
		}
		reader.close();
	}

}
