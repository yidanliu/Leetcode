public class FindPeak {
	public int findPeakElement(int[] nums) {
		if (nums.length == 1) {
			return 0;
		}
		int left = 0, right = nums.length-1;
		while (true) {
			if (left == right) {
				return left;
			}
			int mid = (left + right) / 2;
			// compare middle element
			if ((mid == 0 && nums[mid] > nums[mid+1]) || 
			        (mid == nums.length-1 && nums[mid] > nums[mid-1]) ||
			            (nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]) ) {
			                return mid;
			            }
			if (mid == 0 || nums[mid] > nums[mid-1]) {
				left = mid+1;
			} else {
				right = mid-1;
			}
		}
	}
}