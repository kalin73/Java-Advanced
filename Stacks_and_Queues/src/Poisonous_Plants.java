import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Poisonous_Plants {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		List<Integer> plants = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			plants.add(sc.nextInt());
		}

		ArrayDeque<Integer> stack = new ArrayDeque<>();
		int count = 0;
		boolean removed = false;
		sc.close();
		while (true) {
			for (int i = 1; i < plants.size(); i++) {
				if (plants.get(i) > plants.get(i - 1)) {
					stack.push(i);
					removed = true;
				}
			}
			if (!removed) {
				break;
			} else {
				int size = stack.size();
				for (int k = 0; k < size; k++) {
					int index = stack.pop();
					plants.remove(index);

				}
			}
			removed = false;
			count++;

		}
		System.out.println(count);
	}

}
