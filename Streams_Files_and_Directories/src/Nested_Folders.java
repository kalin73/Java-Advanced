import java.io.File;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class Nested_Folders {

	public static void main(String[] args) {
		File fl = new File("C:\\Users\\Milen\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources");
		File[] arr = fl.listFiles();
		ArrayDeque<File> toTraverse = new ArrayDeque<>(Arrays.asList(arr));
		int folderCount = 0;

		while (toTraverse.size() > 0) {

			File currFile = toTraverse.poll();

			if (currFile.isDirectory()) {
				System.out.println(currFile.getName());
				List<File> filesList = Arrays.asList(currFile.listFiles());
				toTraverse.addAll(filesList);
				folderCount++;
			}
		}
		System.out.println(folderCount + " folders");

	}

}
