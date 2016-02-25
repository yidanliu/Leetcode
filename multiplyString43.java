public class multiplyString43 {
	/*
	 * Given two numbers represented as strings, return multiplication of the numbers as a string.
	 * Note: The numbers can be arbitrarily large and are non-negative.
	 */
	private String multiplySingle(String str, char c) {
		StringBuffer sb = new StringBuffer();
		int add = 0;
		int mul = c-'0';
		for (int i = str.length()-1; i >= 0; i--) {
			char tmp = str.charAt(i);
			int a = tmp-'0';
			int res = a * mul + add;
			int mod = res%10;
			sb.append(mod);
			add = res/10;
		}
		if (add > 0) {
			sb.append(add);
		}
		return sb.reverse().toString();
	}
	
	private String addString(String str1, String str2) {
		StringBuffer sb = new StringBuffer();
		int add  = 0, len1 = str1.length(), len2 = str2.length();
		int a, b;
		for (int i = 0; i < len1 || i < len2; i++) {
			if (len1-1-i >= 0) {
				a = str1.charAt(len1-1-i) - '0';
			} else {
				a = 0;
			}
			if (len2-1-i >= 0) {
				b = str2.charAt(len2-1-i) - '0';
			} else {
				b = 0;
			}
			int sum = a+b+add;
			sb.append(sum%10);
			add = sum/10;
		}
		if (add > 0) {
			sb.append(add);
		}
		return sb.reverse().toString();
	}
	
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        if (len1 < len2) {
        	return multiply(num2, num1);
        }
        String output = "";
        for (int i = len2-1; i >= 0; i--) {
        	char c = num2.charAt(i);
        	if (c == '0') {
        		continue;
        	} else {
        		String res = multiplySingle(num1, c);
        		for (int j = 0; j < len2-i-1; j++) {
        			res += '0';
        		}
        		output = addString(output, res);
        	}
        }
        return output;
    }
}