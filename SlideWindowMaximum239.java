import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SlideWindowMaximum239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n-k+1];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
        	pq.add(nums[i]);
        }
        // output[0] = pq.peek();
        for (int i = k; i < n; i++) {
        	output[i-k] = pq.peek();
        	pq.remove(nums[i-k]);
        	pq.add(nums[i]);
        }
        output[n-k] = pq.peek();
        return output;
    }
}