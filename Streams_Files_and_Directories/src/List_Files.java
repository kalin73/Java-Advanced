import java.io.File;
import java.io.IOException;

public class List_Files {

	public static void main(String[] args) throws IOException {
		File fl = new File(
				"C:\\Users\\Milen\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
		File[] arr = fl.listFiles();
		for (File file : arr) {
			if (!file.isDirectory()) {

				System.out.printf("%s: [%d]%n", file.getName(), file.length());

			}

		}
	}

}
