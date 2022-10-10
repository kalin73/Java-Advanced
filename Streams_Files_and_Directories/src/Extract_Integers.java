import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Extract_Integers {

	public static void main(String[] args) throws FileNotFoundException {
		String path = "C:\\Users\\Milen\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
		String path2 = "C:\\Users\\Milen\\Desktop\\integers.txt";
		Scanner sc = new Scanner(new FileInputStream(path));
		FileOutputStream out = new FileOutputStream(path2);

		try (PrintStream print = new PrintStream(out)) {
			while (sc.hasNext()) {
				if (sc.hasNextInt()) {
					int n = sc.nextInt();
					print.println(n);

				}
				sc.next();
			}
		}
	}

}
