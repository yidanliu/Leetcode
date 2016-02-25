import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = combination(candidates, candidates.length, target);
		return result;
	}
	
	private List<List<Integer>> combination(int[] candidates, int end, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = end-1; i >= 0; i--) {
			if (candidates[i] > target) {
				continue;
			}
			if (i+1 <= end-1 && candidates[i] == candidates[i+1]) {
				continue;
			}
			else if (candidates[i] == target) {
				List<Integer> equal = new ArrayList<Integer>();
				equal.add(candidates[i]);
				result.add(equal);
			}
			else {			// candidates[i] < target
				List<List<Integer>> rest = combination(candidates, i, target-candidates[i]);
				if (rest.isEmpty()) {
					continue;
				} else {
					for (List<Integer> list : rest) {
						list.add(candidates[i]);
						result.add(list);
					}
					
				}
			}
		}
		return result;
	}
}