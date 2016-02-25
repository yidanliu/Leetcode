import java.util.HashMap;
import java.util.Map;

public class ValidPalindrome125 {
    public boolean isPalindrome(String s) {
        Map<Character, Character> caseMap = new HashMap<Character, Character>();
        for (int i = 0; i < 26; i++) {
            caseMap.put((char)('a'+i), (char)('A'+i));
            caseMap.put((char)('A'+i), (char)('a'+i));
            if (i <= 9) {
            	caseMap.put((char)('0'+i), (char)('0'+i));
            }
        }
        int start = 0, end = s.length()-1;
        while (start <= end) {
        	System.out.println(start + "," + end);
            while (start <= end && !caseMap.containsKey(s.charAt(start))){
                start++;
            }
            while (start <= end && !caseMap.containsKey(s.charAt(end))) {
                end--;
            }
            if (start >= end) {
                return true;
            }
            char st = s.charAt(start), ed = s.charAt(end);
            
            if (st == ed || caseMap.get(st) == ed) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
	
}