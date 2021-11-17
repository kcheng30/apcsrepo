public class lucky13 {
	public static boolean lucky13(int[] nums) {
		if ( nums.length != 0 ) {
			if ( nums[0] == 1 || nums[0] == 3 ) return false;
			return lucky13(segment(nums, 1, nums.length));
		}
		return true;
	}

	public static int[] segment(int[] whole, int start, int end) {
                int[] segment = new int[end - start];
                for ( int index = 0; index < segment.length; index++ ) segment[index] = whole[index + start];
                return segment;
        }
}
