public class FlipGameII {
    public boolean canWin(String s) {
        StringBuffer sb = new StringBuffer(s);
        return canWinHelper(sb);

    }
    private boolean canWinHelper(StringBuffer sb) {
    	System.out.println(sb.toString());
        int left = 0;
        while (left < sb.length()-1) {
        	System.out.println(left);
            if (sb.charAt(left) == '+' && sb.charAt(left+1) == '+') {
                sb.setCharAt(left, '-');
                sb.setCharAt(left+1, '-');
               
                boolean otherWin = canWinHelper(sb);
                sb.setCharAt(left, '+');
                sb.setCharAt(left+1, '+');
                if (!otherWin) {
                	return true;
                }
            }
            left++;
        }
        return false;
    }
}