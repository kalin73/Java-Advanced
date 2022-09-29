package Sets;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Parking_Lot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedHashSet<String> licenseNumbs = new LinkedHashSet<>();
		String[] input = sc.nextLine().split(", ");
		
		while (!input[0].equals("END")) {

			if (input[0].equals("IN")) {
				licenseNumbs.add(input[1]);
			} else {
				licenseNumbs.remove(input[1]);
			}
			input = sc.nextLine().split(", ");
		}
		if (licenseNumbs.isEmpty()) {
			System.out.println("Parking Lot is Empty");
		} else {
			licenseNumbs.forEach(x -> System.out.println(x));
		}
		sc.close();
	}

}
