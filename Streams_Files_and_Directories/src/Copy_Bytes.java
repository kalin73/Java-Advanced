import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy_Bytes {

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Kalin\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
		String path2 = "C:\\Users\\Kalin\\Desktop\\newInput.txt";
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;

		try {
			inputStream = new FileInputStream(path);
			outputStream = new FileOutputStream(path2);

			int in = inputStream.read();
			System.out.println(in);
			while (in >= 0) {

				if (in == ' ' || in == '\n') {
					outputStream.write(in);
				} else {
					String digit = String.valueOf(in);
					for (int i = 0; i < digit.length(); i++) {
						outputStream.write(digit.charAt(i));
					}
				}
				in = inputStream.read();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
