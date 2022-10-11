import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Sort_Lines {

	public static void main(String[] args) throws IOException {
		Path input = Paths
				.get("C:\\Users\\Milen\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
		
		Path output = Paths
				.get("C:\\Users\\Milen\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\sorted.txt");
		
		List<String> lines = Files.readAllLines(input);
		lines.sort((f, s) -> f.compareTo(s));
		Files.write(output, lines);
	}

}
