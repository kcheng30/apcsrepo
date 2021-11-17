public class centeredAverage {
	public static int centeredAverage(int[] nums) {
		int max = 0;
		int min = 99999;
		int total = 0;
		for (int i : nums) {
			 if (i > max) max = i;
			 if (i < min) min = i;
			total += i;
		}
		return (total-max-min)/(nums.length-2);
	}
}
