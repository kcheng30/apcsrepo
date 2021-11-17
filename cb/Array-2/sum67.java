public class sum67 {
	public static int sum67(int[] nums) {
		int sum = 0;
		if ( nums.length != 0 ) {
			if ( nums[0] == 6 ) {
				int index = 0;
				while ( nums[index - 1] != 7 ) {
					nums[index] = 0;
					index++;
				}
				nums[index] = 0;
			}
			sum += nums[0] + sum67(segment(nums, 1, nums.length));
		}
		return sum;
	}
	
	public static int[] segment(int[] whole, int start, int end) {
                int[] segment = new int[end - start];
                for ( int index = 0; index < segment.length; index++ ) segment[index] = whole[index + start];
                return segment;
	}
}
