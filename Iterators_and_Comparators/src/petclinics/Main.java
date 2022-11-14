package petclinics;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Pet> pets = new ArrayList<>();
		ArrayList<Clinic> clinics = new ArrayList<>();

		int n = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < n; i++) {
			try {
				String[] input = sc.nextLine().split(" ");
				String command = input[0];

				switch (command) {
				case "Create":
					create(pets, clinics, input);
					break;

				case "HasEmptyRooms":
					emptyRoom(clinics, input);
					break;

				case "Add":
					addPet(pets, input, clinics);
					break;

				case "Release":
					release(clinics, input[1]);
					break;

				case "Print":
					print(input, clinics);
				}

			} catch (Exception e) {
				System.out.println("Invalid Operation!");
			}
		}
		sc.close();
	}

	private static void addPet(ArrayList<Pet> pets, String[] input, ArrayList<Clinic> clinics) {
		String petName = input[1];
		String clinicName = input[2];

		for (Pet p : pets) {
			if (p.getName().equals(petName)) {

				for (Clinic c : clinics) {
					if (c.getName().equals(clinicName)) {
						System.out.println(c.add(p));
						return;
					}
				}
			}
		}
		throw new NullPointerException("Invalid Operation!");

	}

	private static void create(ArrayList<Pet> pets, ArrayList<Clinic> clinics, String[] input) {
		String name = input[2];
		int ageORrooms = Integer.parseInt(input[3]);

		if (input[1].equals("Pet")) {
			String kind = input[4];
			pets.add(new Pet(name, ageORrooms, kind));
		} else {
			clinics.add(new Clinic(name, ageORrooms));
		}

	}

	private static void emptyRoom(ArrayList<Clinic> clinics, String[] input) {
		for (Clinic c : clinics) {
			if (c.getName().equals(input[1])) {
				System.out.println(c.hasEmptyRooms());
				return;
			}
		}
	}

	private static void release(ArrayList<Clinic> clinics, String clinicName) {
		for (Clinic c : clinics) {
			System.out.println(c.release());
		}
	}

	private static void print(String[] input, ArrayList<Clinic> clinics) {
		String clinicName = input[1];

		if (input.length == 3) {
			int roomNumber = Integer.parseInt(input[2]);
			for (Clinic c : clinics) {
				if (c.getName().equals(clinicName)) {
					c.print(roomNumber);
				}
			}
		} else {
			for (Clinic c : clinics) {
				if (c.getName().equals(clinicName)) {
					c.print();
				}
			}
		}

	}
}
