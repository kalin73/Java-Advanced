package Maps;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Academy_Graduation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Map<String, double[]> students = new TreeMap<>();
		double[] grades;

		for (int i = 0; i < n; i++) {

			String name = sc.nextLine();
			grades = Arrays.stream(sc.nextLine().split(" ")).mapToDouble(x -> Double.parseDouble(x)).toArray();
			students.put(name, grades);
		}
		students.forEach((key, value) -> {
			System.out.printf("%s is graduated with ", key);
			double avg = 0;
			double sum = 0.0;
			for (double d : value) {
				sum += d;
			}
			avg = sum / value.length;
			System.out.println(avg);

		});
		sc.close();
	}
}
