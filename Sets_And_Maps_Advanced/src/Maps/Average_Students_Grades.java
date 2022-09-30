package Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Average_Students_Grades {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Map<String, List<Double>> students = new TreeMap<>();
		List<Double> grades = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String[] student = sc.nextLine().split(" ");
			String name = student[0];
			Double grade = Double.parseDouble(student[1]);
			grades = students.get(name);
			if (!students.containsKey(name)) {
				grades = new ArrayList<>();
				grades.add(grade);
				students.put(name, grades);
				continue;
			}
			grades.add(grade);
			students.put(name, grades);
		}

		students.forEach((key, value) -> {

			System.out.print(key + " -> ");
			value.forEach(x -> System.out.printf("%.2f ", x));
			Double avg = 0.0;
			Double sum = 0.0;
			for (Double d : value) {
				sum += d;
			}
			avg = sum / value.size();
			System.out.printf("(avg: %.2f)%n", avg);

		});
		sc.close();
	}

}
