import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Write_to_File {

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Kalin\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
		String path2 = "C:\\Users\\Kalin\\Desktop\\newInput.txt";

		Set<Character> chars = new HashSet<>();
		Collections.addAll(chars, ',', '.', '!', '?');

		FileInputStream inputStream = new FileInputStream(path);
		FileOutputStream outputStream = new FileOutputStream(path2);

		int n = inputStream.read();

		while (n >= 0) {
			char currChar = (char) n;
			if (!chars.contains(currChar)) {

				outputStream.write(currChar);

			}
			n = inputStream.read();
		}
		inputStream.close();
		outputStream.close();
	}

}
