public class bigDiff {
	public static int bigDiff(int[] nums) {
		int max = 0;
		int min = 99999;
		for (int i : nums) {
			 if (i > max) max = i;
			 if (i < min) min = i;
		}
		return max - min;
	}
}
