public class wordSearch {

    public boolean dfs(int x, int y, char[][] board, boolean[][] visited, String word) {
        visited[x][y] = true;
        if (word.length() == 1) {
            return true;
        }
        if (x-1 >= 0 && board[x-1][y] == word.charAt(1) && visited[x-1][y] == false) {
            boolean up = dfs(x-1, y, board, visited, word.substring(1));
            if (up) {
                return true;
            }
        }
        if (x+1 < board.length && board[x+1][y] == word.charAt(1) && visited[x+1][y] == false) {
            boolean down = dfs(x+1, y, board, visited, word.substring(1));
            if (down) {
                return true;
            }
        }
        if (y-1 >=0 && board[x][y-1] == word.charAt(1) && visited[x][y-1] == false) {
            boolean left = dfs(x, y-1, board, visited, word.substring(1));
            if (left) {
                return true;
            }
        }
        if (y+1 < board[0].length && board[x][y+1] == word.charAt(1) && visited[x][y+1] == false) {
            boolean right = dfs(x, y+1, board, visited, word.substring(1));
            if (right) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        // init visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean found = dfs(i, j, board, visited, word);
                    if (found) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}