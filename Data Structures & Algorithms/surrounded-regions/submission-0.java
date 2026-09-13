class Solution {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }

            if (board[i][board[0].length - 1] == 'O') {
                dfs(board, i, board[0].length - 1);
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }

            if (board[board.length - 1][i] == 'O') {
                dfs(board, board.length - 1, i);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        board[x][y] = 'T';
        if (x > 0 && board[x - 1][y] == 'O') {
            dfs(board, x - 1, y);
        }

        if (x < board.length - 1 && board[x + 1][y] == 'O') {
            dfs(board, x + 1, y);
        }

        if (y > 0 && board[x][y - 1] == 'O') {
            dfs(board, x, y - 1);
        } 

        if (y < board[0].length - 1 && board[x][y + 1] == 'O') {
            dfs(board, x, y + 1);
        }
    }
}
