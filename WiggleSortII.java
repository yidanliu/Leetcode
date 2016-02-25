import java.util.Arrays;

public class WiggleSortII {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int mod = nums.length % 2;
        for (int i = 1; i < nums.length-1; i+=2) {
            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                continue;
            }
            int nextIndex = i < nums.length/2+mod ? 2*i : 2*i-nums.length+1-mod;
            System.out.println(i + "==" + nextIndex);
            int nextIndexPreValue = nums[nextIndex];
            int newValue = nums[i];
            while (nextIndex != i) {
            	System.out.println(nextIndex + "," + nextIndexPreValue + "," + newValue);
                nums[nextIndex] = newValue;
                newValue = nextIndexPreValue;
                nextIndex = nextIndex < nums.length/2+mod ? 2*nextIndex : 2*nextIndex-nums.length+1-mod;
                nextIndexPreValue = nums[nextIndex];
            } 
            nums[i] = newValue;
        }
    }
}