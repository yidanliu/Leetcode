public class stringPlus1 {
	public String plusOne (String s) {
		int len = s.length();
		StringBuffer sb = new StringBuffer();
		int i = len-1;
		for (; i >= 0; i--) {
			char c = s.charAt(i);
			if (c != '9') {
				c = (char) (c+1);
				sb.append(c);
				break;
			} else {
				c = '0';
				sb.append(c);
			}
		}
		// if i == -1, add 1 in the beginning
		if (i == -1) {
			sb.append('1');
			return sb.toString();
		} 
		for (; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.reverse().toString();
		
	}
}