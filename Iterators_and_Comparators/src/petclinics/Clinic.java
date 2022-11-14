package petclinics;

import java.util.Iterator;

public class Clinic implements Iterable<Clinic> {
	private String name;
	private int rooms;
	private Pet[] clinic;

	public Clinic(String name, int rooms) {
		this.name = name;
		this.setNumberOfRooms(rooms);
		clinic = new Pet[rooms];
	}

	public boolean add(Pet pet) {
		int center = rooms / 2;
		int left = center - 1;
		int right = center + 1;
		int counter = 0;

		if (rooms == 1) {
			if (clinic[0] == null) {
				clinic[0] = pet;
				return true;
			}
			return false;

		}

		while (counter < rooms / 2) {
			if (clinic[center] == null) {
				clinic[center] = pet;
				return true;

			} else if (left >= 0 && clinic[left] == null) {
				clinic[left] = pet;
				return true;

			} else if (right < rooms && clinic[right] == null) {
				clinic[right] = pet;
				return true;
			}
			left--;
			right++;
			counter++;
		}
		return false;
	}

	public boolean release() {
		int center = rooms / 2;
		if (clinic.length == 0) {
			return false;
		}

		for (int i = center; i < rooms; i++) {
			if (clinic[i] != null) {
				clinic[i] = null;
				return true;
			}

		}
		for (int i = 0; i < center; i++) {
			if (clinic[i] != null) {
				clinic[i] = null;
				return true;
			}

		}
		return false;
	}

	public boolean hasEmptyRooms() {
		if (rooms == 0) {
			return true;
		}
		for (Pet p : clinic) {
			if (p == null) {
				return true;
			}
		}
		return false;
	}

	public String getName() {
		return name;
	}

	private void setNumberOfRooms(int rooms) {
		if (rooms % 2 == 0) {
			throw new IllegalArgumentException("Invalid Operation!");
		}
		this.rooms = rooms;
	}

	public void print(int room) {
		if (clinic[room - 1] == null) {
			System.out.println("Room empty");
		} else {
			System.out.println(clinic[room - 1]);
		}

	}

	public void print() {
		for (Pet p : clinic) {
			if (p == null) {
				System.out.println("Room empty");
			} else {
				System.out.println(p);
			}

		}
	}

	@Override
	public Iterator<Clinic> iterator() {
		return null;
	}

}
