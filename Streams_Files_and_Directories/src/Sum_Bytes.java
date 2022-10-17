import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sum_Bytes {

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Milen\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
		FileReader inpReader = new FileReader(path);
		BufferedReader reader = new BufferedReader(inpReader);

		int currChar = reader.read();
		long sum = 0;
		while (currChar > 0) {
			char c = (char) currChar;
			if (c != '\n' && c != '\r') {
				sum += currChar;
			}
			currChar = reader.read();
		}
		System.out.println(sum);
		reader.close();

	}

}
