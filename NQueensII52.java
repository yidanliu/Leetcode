public class NQueensII52 {
    private boolean checkValid(int row, int[] board) {
        int col = board[row];
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(i-row)==Math.abs(board[i]-board[row])) {
                return false;
            }
        }
        return true;
    }
    public int totalNQueens(int n) {
        int sum = 0;
        int[] board = new int[n];
        int row = 0;
        board[row] = -1;
        while (row >= 0) {
            board[row] += 1;
            while (board[row] < n && !checkValid(row, board)) {	// find the next possible place
                board[row]++;
            }
            if (board[row] < n) {
                if (row == n-1) {
                    sum++;			// feasible solution
                } else {			
                    row = row+1;			// keep going down
                    board[row] = -1;
                }
            } else {				// backtrack
                row--;
            }
        }
        return sum;
    }
}