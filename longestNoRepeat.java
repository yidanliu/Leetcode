import java.util.HashMap;
import java.util.Map;

public class longestNoRepeat {
    public int lengthOfLongestSubstring(String s) {
        // keep a window and a map
    	Map<Character, Integer> visited = new HashMap<Character, Integer>();
    	int start = 0, end = 0;
    	int longest = 1;
    	for (int i = 0; i < s.length(); i++) {
    		char cur = s.charAt(i);
    		if (!visited.containsKey(cur)) {
    			visited.put(cur, i);
    			end++;
    		} else {
    			int previous_pos = visited.get(cur);
    			
    			// start = previous_pos + 1;
    			// start = Math.max(start,previous_pos) + 1;
    			if (start <= previous_pos) {
    			    start = previous_pos + 1;
    			}
    			
    			visited.put(cur, i);
    			end++;
    		}
    		System.out.println(end + "--" + start);
    		longest = Math.max(longest, end-start);
    	}
    	return longest;
    }
}