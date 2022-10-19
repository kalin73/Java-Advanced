import java.io.File;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class Get_Folder_Size {

	public static void main(String[] args) {
		File fl = new File(
				"C:\\Users\\Kalin\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");
		File[] arr = fl.listFiles();

		ArrayDeque<File> toTraverse = new ArrayDeque<>(Arrays.asList(arr));
		int size = 0;

		while (toTraverse.size() > 0) {

			File currFile = toTraverse.poll();

			if (currFile.isDirectory()) {
				System.out.println(currFile.getName());
				List<File> filesList = Arrays.asList(currFile.listFiles());
				toTraverse.addAll(filesList);

			} else {

				size += currFile.length();

			}
		}
		System.out.println("Folder size: " + size);
	}

}
