package fifth.laboratoy.exam.pripremni.prvi;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<List<Integer>> ulaz1 = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(0, 3), Arrays.asList(2, 6)); // 3.26

		System.out.println(Solution.allDigitsMatch(3.266).test(ulaz1));  // true
		System.out.println(Solution.allDigitsDefined().test(ulaz1)); // true

		List<List<Integer>> ulaz2 = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(0, 3), Arrays.asList(3, 6)); // 3.2*6
		System.out.println(Solution.allDigitsMatch(3.266).test(ulaz2)); // true
		System.err.println(Solution.allDigitsDefined().test(ulaz2)); // false

	}

}
