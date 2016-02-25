import java.util.ArrayList;
import java.util.List;

public class encode271 {

//    private String intToBitString(int a) {
//        StringBuffer sb = new StringBuffer();
//        while (a > 0) {
//        	if (a%2 == 0) {
//        		sb.append('0');
//        	} else {
//        		sb.append('1');
//        	}
//            a = a/2;
//        }
//        int toAdd = 8-sb.length();
//        for (int i = 0; i < toAdd; i++) {
//            sb.append('0');
//        }
//        return sb.reverse().toString();
//    }
//    
//    private char bitStringToChar(String str) {
//        int a = 0;
//        for (int i = 0; i < 8; i++) {
//            char c =  str.charAt(i);
//            if (c == '1') {
//                a = a*2+1;
//            } else {
//                a = a*2;
//            }
//        }
//        return (char)a;
//    }
//
//    // Encodes a list of strings to a single string.
//    public String encode(List<String> strs) {
//        StringBuffer sb = new StringBuffer();
//        for (String str : strs) {
//            for (int i = 0; i < str.length(); i++) {
//                char c = str.charAt(i);
//                int b = (int)c;
//                String strB = intToBitString(b);
//                sb.append(strB);
//            }
//            sb.append('3');
//        }
//        return sb.toString();
//    }
//
//    // Decodes a single string to a list of strings.
//    public List<String> decode(String s) {
//        List<String> output = new ArrayList<String>();
//        int idx = 0;
//        StringBuffer sb = new StringBuffer();
//        while (idx < s.length()) {
//            if (s.charAt(idx) != '3') {
//                char c = bitStringToChar(s.substring(idx, idx+8));
//                sb.append(c);
//                if (idx+8 == s.length()) {
//                	idx++;
//                } else {
//                	idx += 8;
//                }
//            } else {
//                output.add(sb.toString());
//                sb.delete(0, sb.length());
//                idx++;
//            }
//        }
//        return output;
//    }
    public String encode(List<String> strs) {
        String res = "";
        for (String s: strs) 
            res += String.format("%d/%s", s.length(), s);
        System.out.println(res);
        return res;
    }

    public List<String> decode(String s) {
        ArrayList<String> res = new ArrayList<String>();        
        int i = 0;
        while (i < s.length()) {
            int slash = s.indexOf('/', i);
            int length = Integer.valueOf( s.substring(i, slash) ); 
            String one = s.substring(slash+1, slash+1+length);
            res.add(one);
            i = slash + 1 + length;
        }           
        return res;
    }   

}