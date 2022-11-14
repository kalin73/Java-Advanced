import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Sort_Even_Numbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> numbers = (ArrayList<Integer>) Arrays.stream(sc.nextLine().split(", "))
				.map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		
		numbers.removeIf(x -> !(x % 2 == 0));
		System.out.println(numbers.toString().replace("[", "").replace("]", ""));
		
		numbers.sort((f, s) -> Integer.compare(f, s));
		System.out.println(numbers.toString().replace("[", "").replace("]", ""));
		
		sc.close();
	}

}
