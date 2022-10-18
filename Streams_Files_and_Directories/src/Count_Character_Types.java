import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Count_Character_Types {

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Milen\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
		FileReader inp = new FileReader(path);
		BufferedReader reader = new BufferedReader(inp);
		PrintWriter writer = new PrintWriter("C:\\Users\\Milen\\Desktop\\output.txt");

		int vaws = 0;
		int symbs = 0;
		int punct = 0;
		String line = reader.readLine();

		while (line != null) {
			for (int i = 0; i < line.length(); i++) {
				char currChar = line.charAt(i);
				if (currChar == 'a' || currChar == 'e' || currChar == 'i' || currChar == 'o' || currChar == 'u') {
					vaws++;

				} else if (currChar == '!' || currChar == ',' || currChar == '.' || currChar == '?') {
					punct++;

				} else if (currChar != ' ') {
					symbs++;

				}

			}

			line = reader.readLine();
		}
		writer.print(String.format("Vowels: %d%nOther symbols: %d%nPunctuation: %d", vaws, symbs, punct));
		writer.flush();
		reader.close();
		writer.close();
	}

}
