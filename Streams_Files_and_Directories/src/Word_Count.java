import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Word_Count {

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Milen\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
		Path path2 = Paths
				.get("C:\\Users\\Milen\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");
		FileReader fr = new FileReader(path);
		BufferedReader reader = new BufferedReader(fr);
		PrintWriter writer = new PrintWriter("C:\\Users\\Milen\\Desktop\\result.txt");
		Map<String, Integer> count = new HashMap<>();

		String line = reader.readLine();
		List<String> lines = Files.readAllLines(path2);
		String[] text; 
for(int i=0;i<lines.size();i++) {
	
	
	
}

		while (line != null) {

			String[] words = line.split(" ");

			for (int i = 0; i < words.length; i++) {
				String word = words[i];
				count.putIfAbsent(word, 1);

				if (lines.contains(word)) {
					if (count.containsKey(word)) {

						count.put(word, count.get(word) + 1);

					}
				}
			}
			line = reader.readLine();
		}
		count.entrySet().stream().sorted((f, s) -> Integer.compare(s.getValue(), f.getValue())).forEach(x -> {

			writer.printf("%s - %d%n", x.getKey(), x.getValue());
			writer.flush();

		});
	}

}
