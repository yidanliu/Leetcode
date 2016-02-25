public class minPathSum64 {
	// dp
//    public int minPathSum(int[][] grid) {
//        int m = grid.length, n = grid[0].length;
//        int[][] minSum = new int[m][n];
//        minSum[0][0] = grid[0][0];
//        for (int i = 1; i < m; i++) {
//        	minSum[i][0] = minSum[i-1][0] + grid[i][0];
//        }
//        for (int i = 1; i < n; i++) {
//        	minSum[0][i] = minSum[0][i-1] + grid[0][i];
//        }
//        for (int i = 1; i < m; i++) {
//        	for (int j = 1; j < n; j++) {
//        		minSum[i][j] = Math.min(minSum[i-1][j], minSum[i][j-1]) + grid[i][j];
//        	}
//        }
//        return minSum[m-1][n-1];
//    }
	// optimized dp
	public int minPathSum(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[] first = new int[m];
		int[] second = new int[m];
		first[0] = grid[0][0];
		for (int i = 1; i < m; i++) {
			first[i] = first[i-1] + grid[i][0];
		}
		for (int j = 1; j < n; j++) {
			second[0] = first[0] + grid[0][j];
			for (int i = 1; i < m; i++) {
				second[i] = Math.min(second[i-1], first[i]) + grid[i][j];
			}
			int[] tmp = first;
			first = second;
			second = tmp;
		}
		return first[m-1];
	}
}