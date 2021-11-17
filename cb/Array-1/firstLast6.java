public class firstLast6 {
	public static boolean firstLast6(int[] nums) {
		if (nums[0] == 6 || nums[nums.length-1] == 6) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] bob = {1, 2, 6};
		System.out.println(firstLast6(bob));
	}
}
