public class sum13 {
	public static int sum13(int[] nums) {
		int sum = 0;
		if ( nums.length != 0 ) {
			if ( nums[0] == 13 ) {
				if ( nums.length != 1 ) nums[1] = 0;
				nums[0] = 0;
			}
			return sum += nums[0] + sum13(segment(nums, 1, nums.length)); 
		}
		return 0;
	}

	public static int[] segment(int[] whole, int start, int end) {
		int[] segment = new int[end - start];
		for ( int index = 0; index < end - start; index++ ) segment[index] = whole[index + start];
		return segment;
	}
}
