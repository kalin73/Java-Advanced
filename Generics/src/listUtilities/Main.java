package listUtilities;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> arrList = Arrays.asList(5, 234, 2, -24, 5, 777, 56);

		System.out.println(ListUtils.getMax(arrList));
		System.out.println(ListUtils.getMin(arrList));
	}

}
