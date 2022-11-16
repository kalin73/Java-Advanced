import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Count_Uppercase_Words {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<String> text = Arrays
				.stream(sc.nextLine().split(" "))
				.filter(x -> Character.isUpperCase(x.charAt(0)))
				.collect(Collectors.toList());

		System.out.println(text.size());
		text.stream().forEach(x -> System.out.println(x));
		
		sc.close();
	}

}
