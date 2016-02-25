public class NextPermutation31 {
    public void nextPermutation(int[] nums) {
        int l, k = nums.length-2;		// find the rightmost l & k, which nums[k] < nums[k+1] && nums[k] < num[l]
        while (k >= 0) { 
        	if (nums[k] >= nums[k+1]) {
        		k--;
        	} else {
        		break;
        	}
        	
        }
        if (k < 0) {
        	return ;
        }
        l = k+1;
        while (l < nums.length) {
        	if (l+1 < nums.length && nums[l+1] > nums[k]) {
        		l++;
        	} else {
        		break;
        	}
        }
        int tmp = nums[k];
        nums[k] = nums[l];
        nums[l] = tmp;
        
        int left = k+1, right = nums.length-1;
        while (left < right) {
        	tmp = nums[left];
        	nums[left] = nums[right];
        	nums[right] = tmp;
        	left++;
        	right--;
        }
    }
}