public class PaintHouseII265 {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if (n == 0) {
            return 0;
        }
        int k = costs[0].length;
        // we only need two rows
        int[][] total = new int[n][k];
        int d1 = 0, d2 = 0;
        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (i == 0) {
                    total[0][j] = costs[0][j];
                } else {
                    total[i][j] = (d1 == j ? total[i-1][d2] : total[i-1][d1]) + costs[i][j];
                }
            }
            d1 = 0;
            d2 = 0;
            m1 = Integer.MAX_VALUE;
            m2 = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (total[i][j] < m1) {
                    m1 = total[i][j];
                    d1 = j;
                }
            }
            for (int j = 0; j < k; j++) {
                if (total[i][j] < m2 && j != d1) {
                    m2 = total[i][j];
                    d2 = j;
                }
            }
            
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            min = Math.min(total[n-1][i], min);
        }
        return min;
    }
}