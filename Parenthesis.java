import java.util.ArrayList;
import java.util.List;

public class Parenthesis {
    public List<Integer> diffWaysToCompute(String input) {
        int len = input.length();
        // len-1 is included
        List<Integer> ways = compute(input, 0, len-1);
        return ways;
    }
    
    // divide and conquer
    private List<Integer> compute(String input, int start, int end) {
    	System.out.println(start + " " + end);
    	List<Integer> result = new ArrayList<Integer>();

    	for (int pos = start; pos <= end; pos++) {
    		char cur = input.charAt(pos);
    		if (cur == '*' || cur == '-' || cur == '+') {
	    		List<Integer> left = compute(input, start, pos-1);
	    		List<Integer> right = compute(input, pos+1, end);
	    		System.out.println(left.size() + "===" + right.size());

	    		for (int val_left : left) {
	    			for (int val_right : right) {
	    				if (input.charAt(pos) == '*') {
	    					result.add(val_left * val_right);
	    				} else if (input.charAt(pos) == '-') {
	    					result.add(val_left - val_right);
	    				} else {
	    					result.add(val_left + val_right);
	    				}
	    			}
	    		}
    		}
    	}
    	if (result.size() == 0 && end >= start) {
    		int val = Integer.valueOf(input.substring(start, end+1));
    		result.add(val);
    	}
    	
    	return result;
    }
  
}