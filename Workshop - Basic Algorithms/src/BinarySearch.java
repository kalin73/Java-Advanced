import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int target = Integer.parseInt(sc.nextLine());

		int index = binarySearch(arr, target);
		System.out.println(index);

		sc.close();
	}

	private static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			int currNumb = arr[mid];

			if (currNumb == target) {
				return mid;
			}

			if (currNumb < target) {
				left = mid + 1;

			} else if (currNumb > target) {
				right = mid - 1;

			}
		}
		return -1;
	}
}
