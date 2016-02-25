import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class threeSumSmaller259 {
	public int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
		int output = 0;
		
		return output;
	}
//	public int threeSumSmaller(int[] nums, int target) {
//		Arrays.sort(nums);
//		// get frequency
//		Map<Integer, Integer> mapFreq = new HashMap<Integer, Integer>();
//		for (int i = 0; i < nums.length; i++) {
//		    if (mapFreq.containsKey(nums[i])) {
//		        mapFreq.put(nums[i], mapFreq.get(nums[i])+1);
//		    } else {
//		        mapFreq.put(nums[i], 1);
//		    }
//		}
//		// key is summation of 2 numbers, inner key & value are positions
//		Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
//		for (int i = 0; i < nums.length; i++) {
//			if (i > 0 && nums[i - 1] == nums[i]) {
//				continue;
//			}
//			for (int j = i + 1; j < nums.length; j++) {
//				if (j > i+1 && nums[j - 1] == nums[j]) {
//					continue;
//				}
//				int sum2 = nums[i] + nums[j];
//				Map<Integer, Integer> innerMap;
//				if (!map.containsKey(sum2)) {
//					innerMap = new HashMap<Integer, Integer>();
//				} else {
//					innerMap = map.get(sum2);
//				}
//				innerMap.put(nums[i], nums[j]);
//				map.put(sum2, innerMap);
//
//			}
//		}
//		for (int key : map.keySet()) {
//			System.out.println(key + "," + map.get(key).size());
//		}
//		// traverse
//		int output = 0;
//		for (int i = 0; i < nums.length; i++) {
//
//			if (i > 0 && nums[i - 1] == nums[i]) {
//				continue;
//			}
//
//			for (int key : map.keySet()) {
//				if (key + nums[i] < target) {
//
//					Map<Integer, Integer> innerMap = map.get(key);
//					output += innerMap.size();
//					for (int innerKey : innerMap.keySet()) {
//						System.out.println(nums[i] + "@@" +innerKey + "@@" + innerMap.get(innerKey));
//						if (innerKey < nums[i]) {
//						    output--;
//						    continue;
//						}
//						if (innerKey == nums[i] && innerMap.get(innerKey) == nums[i])  {
//						    output = mapFreq.get(nums[i]) >= 3 ? output : output-1;
//						} else if (innerKey <= nums[i] || innerMap.get(innerKey) == nums[i]) {
//						    output = mapFreq.get(nums[i]) >= 2 ? output : output-1;
//						}
//						System.out.println(output);
//						
//					}
//				}
//			}
//		}
//		System.out.println(output);
//		return output;
//	}
}
