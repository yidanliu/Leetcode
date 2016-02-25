public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int left = 0, right = nums.length-1;
        int min = nums[left], max = nums[right];
        boolean found = false;  // found the min and max, search for middle element
        while (left <= right) {
            if (nums[left] >= max) {
                max = Math.min(max, nums[left]);
                max = Math.max(max, nums[right]);
                right--;
            } else if (nums[left] < max && found == false) {
                found = true;
                min = Math.min(min, nums[left]);
                max = Math.max(max, nums[right]);
                right--;
            } else {
                if (nums[left] > min) {
                    return true;
                }
                min = nums[left];
                left++;
            }
        }
        
        left = 0;
        right = nums.length-1;
        min = nums[left];
        max = nums[right];
        found = false;  // found the min and max, search for middle element
        while (left <= right) {
            if (nums[left] >= max) {
                max = Math.min(max, nums[left]);
                max = Math.max(max, nums[right]);
                left++;
            } else if (nums[left] < max && found == false) {
                found = true;
                min = Math.min(min, nums[left]);
                max = Math.max(max, nums[right]);
                right--;
            } else {
                if (nums[left] > min) {
                    return true;
                }
                min = nums[left];
                left++;
            }
        }
        return false;
    }
}