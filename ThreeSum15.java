import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum15 {
	public List<List<Integer>> Solution(int[] nums) {

		Arrays.sort(nums);
		int len = nums.length;
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		for (int i = 0; i < len; i++) {
			if (nums[i] > 0) {
				break;
			}
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int start = i + 1, end = len - 1;
			while (start < end) {
				if (nums[start] + nums[end] == -nums[i]) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[i]);
					list.add(nums[start]);
					list.add(nums[end]);
					output.add(list);
					// increment/decrement is important
					while (start < end && nums[start + 1] == nums[start]) {
						start++;
					}
					start++;
					while (start < end && nums[end - 1] == nums[end]) {
						end--;
					}
					end--;
				} else if (nums[start] + nums[end] < -nums[i]) {
					while (start < end && nums[start + 1] == nums[start]) {
						start++;
					}
					start++;
				} else {
					while (start < end && nums[end - 1] == nums[end]) {
						end--;
					}
					end--;
				}
			}
		}
		return output;
	}

	public List<List<Integer>> threeSumMap(int[] nums) {
		int len = nums.length;
		Arrays.sort(nums);
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Map<Integer, List<Pair>> map = new HashMap<Integer, List<Pair>>();
		for (int i = 0; i < len; i++) {
			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}
			for (int j = i + 1; j < len; j++) {
				if (nums[j - 1] == nums[j]) {
					continue;
				}
				int sum2 = nums[i] + nums[j];
				Pair p = new Pair(i, j);
				List<Pair> list;
				if (map.containsKey(sum2)) {
					list = map.get(sum2);
				} else {
					list = new ArrayList<Pair>();
				}
				list.add(p);
				map.put(sum2, list);
			}
		}

		for (int i = 0; i < len; i++) {
			if (nums[i] > 0) {
				break;
			}
			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}
			int value = nums[i];
			if (map.containsKey(-value)) {
				List<Pair> list = map.get(-value);
				for (Pair p : list) {
					if ( (p.first == i || p.second == i ) || (nums[p.first]) < nums[i]) {
						continue;
					}
					List<Integer> resList = new ArrayList<Integer>();
					resList.add(nums[i]);
					resList.add(nums[p.first]);
					resList.add(nums[p.second]);
					output.add(resList);
				}
			}
		}
		return output;
	}
	
	class Pair {
		int first;
		int second;
		Pair(int x, int y) {
			first = x;
			second = y;
		}
	}
}