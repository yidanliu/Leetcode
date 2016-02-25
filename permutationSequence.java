import java.util.List;
import java.util.ArrayList;

public class permutationSequence {
	// k = n! - a * (n-1)! - b* (n-2)! ... a, b indicate how many numbers after the current are larger than the current number
	
    public String getPermutation(int n, int k) {
    	int factorial = fac(n), nextFactor = factorial/n;
    	int curIndex = n;
    	StringBuffer sb = new StringBuffer();
    	List<Integer> input = new ArrayList<Integer>();
    	for (int i = n; i >= 1; i--) {
    		input.add(i);
    	}
    	while (k != factorial && curIndex > 0) {
    		int divide = (factorial - k) / nextFactor;
    		// System.out.println(factorial + "," + nextFactor +","+divide);
    		sb.append(input.get(divide));
    		input.remove(divide);
    		factorial -= divide * nextFactor;
    		
    		curIndex--;
    		nextFactor /= curIndex;
    	}
    	
    	for (int i = 0; i < input.size(); i++) {
    		sb.append(input.get(i));
    	}
    	
    	return sb.toString();
    }
    
    private int fac(int n) {
    	int res = 1;
    	for (int i = 1; i <= n; i++) {
    		res *= i;
    	}
    	return res;
    }
}