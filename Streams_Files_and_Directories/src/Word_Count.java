import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Word_Count {

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Kalin\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
		String path2 = "C:\\Users\\Kalin\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
		FileReader fr = new FileReader(path);
		BufferedReader reader = new BufferedReader(fr);
		PrintWriter writer = new PrintWriter("C:\\Users\\Kalin\\Desktop\\result.txt");
		Map<String, Integer> count = new HashMap<>();

		String line = reader.readLine();

		while (line != null) {

			String[] words = line.split(" ");
			FileReader fr2 = new FileReader(path2);
			BufferedReader reader2 = new BufferedReader(fr2);
			String line2 = reader2.readLine();

			while (line2 != null) {
				String[] text = line2.split(" ");
				for (int i = 0; i < words.length; i++) {
					for (int k = 0; k < text.length; k++) {
						String word = words[i];

						if (word.equals(text[k])) {
							if (count.containsKey(word)) {

								count.put(word, count.get(word) + 1);

							}
							count.putIfAbsent(word, 1);
						}

					}
				}
				line2 = reader2.readLine();
			}
			line = reader.readLine();
			reader2.close();
		}

		count.entrySet().stream().sorted((f, s) -> Integer.compare(s.getValue(), f.getValue())).forEach(x -> {

			writer.printf("%s - %d%n", x.getKey(), x.getValue());
			writer.flush();

		});

		reader.close();
		writer.close();

	}

}
