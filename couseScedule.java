import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class couseScedule {
	// Cycle detection - DFS
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// adjacency list
		Map<Integer, ArrayList<Integer>> adjList = new HashMap<Integer, ArrayList<Integer>>();

		// iterate over edges
		Set<Integer> initial = new HashSet<Integer>();
		for (int i = 0; i < prerequisites.length; i++) {
			int src = prerequisites[i][0];
			int tar = prerequisites[i][1];
			initial.add(src);
			initial.add(tar);
			ArrayList<Integer> list;
			if (adjList.containsKey(src)) {
				list = adjList.get(src);
			} else {
				list = new ArrayList<Integer>();
			}
			list.add(tar);
			adjList.put(src, list);
		}

		// DFS
		Set<Integer> visited = new HashSet<Integer>();
		while (visited.size() != initial.size()) {
			int srcNode = selectSrcNode(initial, visited);
			if (srcNode == -1) {
				return true;
			}

			boolean isCycled = dfsHelper(srcNode, adjList, visited);
			if (isCycled) {
				return false;
			}
		}

		return true;
	}

	// return if contains cycle
	private boolean dfsHelper(int srcNode, 
			Map<Integer, ArrayList<Integer>> adjList, Set<Integer> visited) {
		
	//	toVisited.push(srcNode);
		
		Stack<Integer> curStack = new Stack<Integer>();
		curStack.push(srcNode);
		while (!curStack.isEmpty()) {
			int curNode = curStack.peek();
			if (adjList.containsKey(curNode)) {
				ArrayList<Integer> neighbors = adjList.get(curNode);
				if (neighbors.size() == 0) {
					curStack.pop();
					visited.add(curNode);
				} else {
					int curNeighbor = neighbors.get(0);
					if (curStack.contains(curNeighbor)) {
						return true;
					}
					curStack.push(curNeighbor);
					neighbors.remove(0);
				}
			} else {
				curStack.pop();
				visited.add(curNode);
			}
		}
		
		return false;
	}

	private int selectSrcNode(Set<Integer> initial, Set<Integer> visited) {
		for (int course : initial) {
			if (!visited.contains(course)) {
				return course;
			}
		}
		return -1;
	}
}