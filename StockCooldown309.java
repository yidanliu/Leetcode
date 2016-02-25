import java.util.HashMap;
import java.util.Map;

public class StockCooldown309 {

    public int maxProfit(int[] prices) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();

        int res = maxProfitHelper(prices, 0, prices.length-1, map);
        return res;
    }
    
    private int maxProfitHelper(int[] prices, int start, int end, Map<Integer, Map<Integer, Integer>> map) {
       
        if (end-start == 0 || start >= prices.length) {
            return 0;
        }
        if (end-start == 1) {
            return Math.max(0,prices[end]-prices[start]);
        }
        if (map.containsKey(start) && map.get(start).containsKey(end)) {
            return map.get(start).get(end);
        }
        while (start < end-1 && prices[start] >= prices[start+1]) {
            start++;
        }
        if (map.containsKey(start) && map.get(start).containsKey(end)) {
            return map.get(start).get(end);
        }
        int res = maxProfitHelper(prices,start+2, end,map);
        for (int i = start+1; i <= end; i++) {
            if (prices[i] > prices[start]) {
                res = Math.max(res, prices[i]-prices[start]+maxProfitHelper(prices, i+2, end, map));
            }
        }
        
        Map<Integer,Integer> inner = map.containsKey(start) ? map.get(start) : new HashMap<Integer, Integer>();
        inner.put(end, res);
        map.put(start, inner);
        return res;
    }
}