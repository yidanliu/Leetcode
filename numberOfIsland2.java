import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class numberOfIsland2 {
    private Map<Integer, Set<Integer>> sets;
    private Map<Integer, Integer> setNumberOfNode;
    
    
    private int union(int set1, int set2) {// use the smaller set id
    	if (set1 == set2) {
    		return set1;
    	}
        if (set2 < set1) {
            return union(set2, set1);
        }
        System.out.println(set1 +"," + set2);
        Set<Integer> set = sets.get(set1);
        for (Integer node : sets.get(set2)) {
            set.add(node);
            setNumberOfNode.put(node, set1);
        }
        sets.remove(set2);
        return set1;
    }
    
    private int addLand(int x, int y, int m, int n) {
        // add
        int nodeNumber = x*n + y;
        Set<Integer> newSet = new HashSet<Integer>();
        newSet.add(nodeNumber);
        sets.put(nodeNumber, newSet);
        setNumberOfNode.put(nodeNumber, nodeNumber);
        // check vertical
        if (x-1 >= 0 && setNumberOfNode.containsKey((x-1)*n+y)) {
            nodeNumber = union(setNumberOfNode.get((x-1)*n+y), nodeNumber);
        }
        if (x+1 < m && setNumberOfNode.containsKey((x+1)*n+y)) {
            nodeNumber = union(setNumberOfNode.get((x+1)*n+y), nodeNumber);
        }
        // check horizontal
        if (y-1 >= 0 && setNumberOfNode.containsKey(x*n+y-1)) {
            nodeNumber = union(setNumberOfNode.get(x*n+y-1), nodeNumber); 
        }
        if (y+1 < n && setNumberOfNode.containsKey(x*n+y+1)) {
            nodeNumber = union(setNumberOfNode.get(x*n+y+1), nodeNumber); 
        }
        return sets.size();
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
    	sets = new HashMap<Integer, Set<Integer>>();
    	setNumberOfNode = new HashMap<Integer, Integer>();
    	List<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i < positions.length; i++) {
            int num = addLand(positions[i][0], positions[i][1], m, n);
            output.add(num);
        }

        return output;
    }
}