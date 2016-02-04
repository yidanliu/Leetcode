import java.util.ArrayList;
import java.util.List;

public class NQueens51 {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> output = new ArrayList<List<String>>();
		// board[i] indicates the column of the queue on the i-th row
		int[] board = new int[n];
		solveHelper(0, 0, board, output);
		return output;
	}
	
	private void solveHelper(int row, int col, int[] board, List<List<String>> output) {
		// System.out.println(row+ " " + col);
		
		while (!(row == 0 && col == board.length)) {
			if (checkValid(row, col, board)) {
				board[row] = col;
				if (row == board.length-1 ) {	// save result
					saveResult(board, output);
					if (col < board.length-1) {
						col += 1;
					} else {
						while (row >= 0 && board[row] == board.length-1) {
							row--;
						}
						if (row >= 0) {
							col = board[row]+1;
						} else {
							break;
						}
					}
				} else {
					row = row+1;
					col = 0;
				}
				
			} else {	// not valid
				if (col < board.length-1) {
					col += 1;
				} else {
					row = row-1;
					while (row >= 0 && board[row] == board.length-1) {
						row--;
					}
					if (row >= 0) {
						col = board[row] +1;
					} else {
						break;
					}
				}
				
			}
		}
		/*
		
		if (checkValid(row, col, board)) {
			board[row] = col;
			if (row == board.length-1) {
				// record result
				saveResult(board, output);
				if (col < board.length-1) {
					solveHelper(row, col+1, board, output);
				} else { // backtrack
					while (row >=0 && board[row]==board.length-1) {
						row--;
					}
					if (row >= 0) {
						solveHelper(row, board[row]+1, board, output);
					}
				}
			} else {
				solveHelper(row+1, 0, board, output);
			}
		} else {
			if (col < board.length-1) {
				solveHelper(row, col+1, board, output);
			} else {
				row = row-1;
				while (row >= 0 && board[row] == board.length-1) {
					row--;
				}
				if (row >= 0) {
					solveHelper(row, board[row]+1, board, output);
				}
			}
		}
		*/
		
	}
	

	
	private void saveResult(int[] board, List<List<String>> output) {
		List<String> list = new ArrayList<String>();
		for (int i = 0 ; i < board.length; i++) {
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < board.length; j++) {
				sb.append(j == board[i] ? "Q" : ".");
			}
			list.add(sb.toString());
			// System.out.println(sb.toString());
		}
		output.add(list);
	}

	private boolean checkValid(int row, int col, int[] board) {
		// check row
		for (int i = 0; i < row; i++) {
			if (board[i] == col) {
				return false;
			}
		}
		// check diagonal
		int diff = row-col;
		int sum = col+row;
		for (int i = 0; i < row; i++) {
			if (Math.abs(i-row) == Math.abs(board[i]-col)) {
				return false;
			}
		}
		return true;
	}

	//	private void solveHelper(int x, int y, List<Integer> solution, int[][] board, List<List<String>> output) {
//		 
//			setBoard(board, x, y);
//			board[x][y] = 1;
//			solution.add(x*board.length+y);
//			
//			if (solution.size() == board.length) {
//				List<String> list = new ArrayList<String>();
//				int index = 0;
//				for (int i = 0; i < board.length; i++) {
//					StringBuffer sb = new StringBuffer();
//					for (int j = 0; j < board.length; j++) {
//						if (i*board.length + j == solution.get(index)) {
//							sb.append("Q");
//						} else {
//							sb.append(".");
//						}
//					}
//					System.out.println(sb.toString());
//					list.add(sb.toString());
//				}
//				output.add(list);
//			} 
//			int nextX = x, nextY = y;
//			while (nextX < board.length && board[nextX][nextY] == 1) {
//				nextY = (nextY+1)%board.length;
//				nextX = nextY == 0 ? nextX+1:nextX;
//			}
//			if (nextX != board.length) {
//				solveHelper(nextX, nextY, solution, board, output);
//			}
//			
//			solution.remove(solution.size()-1);
//			setBoard(board,x,y);
//			board[x][y] = 1;
//			nextX = x; nextY = y;
//			while (nextX < board.length && board[nextX][nextY] == 1) {
//				nextY = (nextY+1)%board.length;
//				nextX = nextY == 0 ? nextX+1:nextX;
//			}
//	}
//	private void reset(int[][] board) {
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[0].length; j++) {
//				board[i][j] = 0;
//			}
//		}
//	}
//	private void setBoard(int[][] board, int x, int y) {
//		// set row
//		int n = board.length;
//		for (int i = 0; i < n; i++) {
//			board[x][i] = 1^board[x][i];
//		}
//		// set column
//		for (int i = 0; i < n; i++) {
//			board[i][y] = 1^board[x][i];
//		}
//		// set diagonal
//		for (int i = 0; i < n; i++) {
//			if (y+i-x >= 0 && y+i-x < n) {
//				board[i][y+i-x] = 1^board[x][i];
//			}	
//			if (x+y-i >= 0 && x+y-i < n) {
//				board[i][x+y-i] = 1^board[x][i];
//			}
//		}
//		
//	}
//	
//	public List<List<String>> solveNQueens(int n) {
//		List<List<String>> output = new ArrayList<List<String>>();
//		int[][] board = new int[n][n];
//		int count = 0;
//		for (int i = 0; i < n; i++) {
//			count = 0;
//			reset(board);
//			setBoard(board, 0, i);
//			board[0][i] = 2;
//			count++;
//			for (int j = 1; j < n; j++) {
//				for (int k = 0 ; k < n; k++) {
//					if (board[j][k] == 0) {
//						setBoard(board, j, k);
//						board[j][k] = 2;
//						count++;
//					}
//				}
//			}
//			if (count == n) {
//				List<String> list = new ArrayList<String>();
//				for (int j = 0; j < n; j++) {
//					StringBuffer sb = new StringBuffer();
//					for (int k = 0; k < n; k++) {
//						sb.append(board[j][k] == 2 ? "Q" : ".");
//					}
//					list.add(sb.toString());
//				}
//				output.add(list);
//			}
//		}
//		return output;
//	}
}