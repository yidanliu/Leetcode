import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII47 {
	public List<List<Integer>> getAllPermuation(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		List<Integer> sol = new ArrayList<Integer>();
		getHelper(nums, used, sol, res);
		return res;
	}
	
	private void getHelper(int[] nums, boolean[] used, List<Integer> sol, List<List<Integer>> res) {
		System.out.println("used:" + used[0] + "," + used[1] + "," + used[2] + "," + used[3]);

		if (sol.size() == nums.length) {
			res.add(new ArrayList<Integer>(sol));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.println(i + " " + sol.size() + ":");
			for (int x : sol) {
				System.out.print(" " + x);
			}
			System.out.println();
			if (i > 0 && nums[i] == nums[i-1] && used[i-1] == false) {
				continue;
			}
			if (used[i] == false) {
				used[i] = true;
				sol.add(nums[i]);
				getHelper(nums, used, sol, res);
				sol.remove(sol.size() -1);
				used[i] = false;
			}
		}
	}
}