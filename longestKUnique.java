import java.util.HashMap;
import java.util.Map;

public class longestKUnique {
	public String findLongestKUnique(String ss, int m) {
		//find longest substring with at most m distinct characters
		//maintain window
		int len = ss.length();
		int start = 0, end = 0;
		int maxStart = 0, maxEnd = 0;
		Map<Character, Integer> posMap = new HashMap<Character, Integer>();
		while (end < len) {
			char c = ss.charAt(end);
			if (posMap.containsKey(c)) {
				posMap.put(c, end);
			} else {
				// add c into current substring
				posMap.put(c, end);
				if (posMap.size() > m) {
					start = posMap.get(ss.charAt(start))+1;
				}
			}
			if ((maxEnd-maxStart) < (end-start)) {
				maxStart = start;
				maxEnd = end;
			}
			end++;
		}
		return ss.substring(maxStart, maxEnd);
	}
}