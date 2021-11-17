public class has22 {
	public static boolean has22(int[] nums) {
		if ( nums.length > 1 ) {
			if ( nums[0] == 2 && nums[1] == 2 ) return true;
			return has22(segment(nums, 1, nums.length));
		}
		return false;
	}

	public static int[] segment(int[] whole, int start, int end) {
                int[] segment = new int[end - start];
                for ( int index = 0; index < segment.length; index++ ) segment[index] = whole[index + start];
                return segment;
        }
}
