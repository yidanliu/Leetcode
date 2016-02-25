import java.util.HashMap;
import java.util.Map;

public class fractionToDecimal166 {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuffer res = new StringBuffer();
        if ((numerator<0) != (denominator<0)) {
            res.append("-");
        }
        long first = numerator, second = denominator;
        first = Math.abs(first);
        second = Math.abs(second);
        res.append(Long.toString(first/second));
        System.out.println(first + " " + second);
        if (first%second == 0) {
            return res.toString();
        }
        res.append(".");
        Map<Long, Integer> divideMap = new HashMap<Long, Integer>();
        long divide = first%second;
        int offset = res.length();
        while (true) {
            System.out.println(divide);

            if (divide*10 % second == 0) {
                res.append(Long.toString(divide*10/second));
                return res.toString();
            }
            if (divideMap.containsKey(divide)) {
                int index = divideMap.get(divide);
                res.insert(index, "(");
                res.append(")");
                return res.toString();
            } else {
                
                divideMap.put(divide, offset);
                offset++;
                res.append(Long.toString(divide*10/second));
                divide = divide *10 % second;
            }
        }
    }

}