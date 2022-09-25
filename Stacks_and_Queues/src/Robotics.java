import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Robotics {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(";");
		int[] time = Arrays.stream(sc.nextLine().split(":")).mapToInt(x -> Integer.parseInt(x)).toArray();
		int hours = time[0];
		int minutes = time[1];
		int seconds = time[2];
		LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
		ArrayDeque<Integer> queue = new ArrayDeque<>();

		for (int i = 0; i < input.length; i++) {

			String[] robot = input[i].split("-");
			robots.put(robot[0], Integer.parseInt(robot[1]));

		}
		String product = sc.nextLine();
		
		while (!"End".equals(product)) {
			
			

		}
	}

}
