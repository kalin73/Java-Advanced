import java.io.FileInputStream;
import java.io.IOException;

public class Read_File {

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Kalin\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
		FileInputStream inputStream = new FileInputStream(path);
		int n = inputStream.read();
		while (n >= 0) {
			System.out.print(Integer.toBinaryString(n) + " ");
			n = inputStream.read();
		}
		inputStream.close();
	}

}
