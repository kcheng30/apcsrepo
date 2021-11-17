public class sameFirstLast {
	public static boolean sameFirstLast(int[] nums) {
		if (nums.length == 0) {
			return false;
		}
		if (nums[0] == nums[nums.length-1]) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] bob = {1, 2, 3, 1};
		System.out.println(sameFirstLast(bob));
	}
}
