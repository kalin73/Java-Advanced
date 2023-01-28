package tupleAndThreeuple;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] input = sc.nextLine().split(" ");
		String name = input[0] + " " + input[1];
		Threeuple<String, String, String> threeuple1 = new Threeuple<>(name, input[2], input[3]);
		System.out.println(threeuple1);

		input = sc.nextLine().split(" ");
		Integer liters = Integer.parseInt(input[1]);
		Boolean drink = input[2].equals("drunk") ? true : false;
		Threeuple<String, Integer, Boolean> threeuple2 = new Threeuple<>(input[0], liters, drink);
		System.out.println(threeuple2);

		input = sc.nextLine().split(" ");
		Double doubleValue = Double.parseDouble(input[1]);
		Threeuple<String, Double, String> threeuple3 = new Threeuple<>(input[0], doubleValue, input[2]);
		System.out.println(threeuple3);

		sc.close();

	}

}
