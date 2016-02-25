import java.util.LinkedList;
import java.util.Queue;

public class shortestBuilding317 {
	int maxDistance = Integer.MAX_VALUE;
	
    public int shortestDistance(int[][] grid) {
        int shortest = Integer.MAX_VALUE;
        int m = grid.length, n = grid[0].length;
        int[][] total = new int[m][n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		total[i][j] = Integer.MAX_VALUE;
        	}
        }
        int curNum = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 1) {
        			bfs(i, j, grid, total, curNum);
        			curNum--;
        		}
        	}
        }
        
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == curNum)
        			shortest = shortest < total[i][j] ? shortest : total[i][j];
        	}
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

	private void bfs(int x, int y, int[][] grid, int[][] total, int curNum) {
		// TODO Auto-generated method stub
		int m = grid.length, n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = false;
			}
		}
		Queue<Node> queue = new LinkedList<Node>();
		Node first = new Node(x, y, 0);
		queue.offer(first);
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			System.out.println(cur.x+","+cur.y);
			if (grid[cur.x][cur.y] == curNum)
				total[cur.x][cur.y] = total[cur.x][cur.y] == Integer.MAX_VALUE ? cur.distance
					: total[cur.x][cur.y] + cur.distance;
			grid[cur.x][cur.y]--;
			if (cur.x + 1 < m && grid[cur.x+1][cur.y] == curNum && !visited[cur.x+1][cur.y]) {
				queue.offer(new Node(cur.x+1, cur.y, cur.distance+1));
				visited[cur.x+1][cur.y] = true;
			}
			if (cur.x - 1 >= 0 && grid[cur.x-1][cur.y] == curNum && !visited[cur.x-1][cur.y]) {
				queue.offer(new Node(cur.x-1, cur.y, cur.distance+1));
				visited[cur.x-1][cur.y] = true;
			}
			if (cur.y + 1 < n && grid[cur.x][cur.y+1] == curNum && !visited[cur.x][cur.y+1]) {
				queue.offer(new Node(cur.x, cur.y+1, cur.distance+1));
				visited[cur.x][cur.y+1] = true;
			}
			if (cur.y - 1 >= 0 && grid[cur.x][cur.y-1] == curNum && !visited[cur.x][cur.y-1]) {
				queue.offer(new Node(cur.x, cur.y-1, cur.distance+1));
				visited[cur.x][cur.y-1] = true;
			}
		}

	}
	
	class Node {
		int x;
		int y;
		int distance;
		Node(int xx, int yy, int dist) {
			x =xx;
			y = yy;
			distance = dist;
		}
	}
}