import java.util.Scanner;

public class Find_Evens_or_Odds {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] bounds = sc.nextLine().split(" ");
		String condidtion = sc.nextLine();
		
		print(bounds, condidtion);
		sc.close();

	}

	private static void print(String[] bounds, String condition) {
		int min = Integer.parseInt(bounds[0]);
		int max = Integer.parseInt(bounds[1]);

		for (int i = min; i <= max; i++) {

			if (condition.equals("even") && i % 2 == 0) {
				System.out.print(i + " ");
				continue;
			} else if (condition.equals("odd") && i % 2 != 0) {
				System.out.print(i + " ");
			}

		}

	}
}
