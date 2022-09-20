import java.util.ArrayDeque;
import java.util.Scanner;

public class Decimal_to_Binary_Converter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayDeque<Integer> result = new ArrayDeque<>();
		sc.close();
		if (n == 0) {
			System.out.println(0);
			return;
		}
		while (n > 0) {
			result.push(n % 2);
			n /= 2;
		}
		result.forEach(x -> System.out.print(x));

	}

}
