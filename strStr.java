public class strStr {
	// Returns the index of the first occurrence of 
	// needle in haystack, or -1 if needle is not part of haystack.
    public int strStr(String haystack, String needle) {
    	if (haystack == null || needle == null) {
    		return -1;
    	}
    	if (needle.length() > haystack.length()) {
    		return -1;
    	}
        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
        	boolean found = true;
        	for (int j = 0; j < needle.length(); j++) {
        		if (haystack.charAt(i+j) != needle.charAt(j)) {
        			found = false;
        			break;
        		}
        	}
        	if (found) {
        		return i;
        	}
        }   
    	return -1;
    }
}