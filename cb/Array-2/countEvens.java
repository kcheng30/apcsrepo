public class countEvens {
	public static int countEvens(int[] nums) {
		int ctr = 0;
		for (int i : nums) if (i % 2 == 0) ctr++;
		return ctr;
	}
}
