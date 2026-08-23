class Solution {
    int ROWS,COLS;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;
        for(int r=0;r<ROWS;r++){
            if(board[r][0] == 'O') secure(board,r,0);
            if(board[r][COLS-1] == 'O') secure(board,r,COLS-1);
        }
        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == 'O') {
                secure(board, 0, c);
            }
            if (board[ROWS - 1][c] == 'O') {
                secure(board, ROWS - 1, c);
            }
        }

        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(board[r][c]=='O') board[r][c] = 'X';
                else if(board[r][c]=='T') board[r][c] = 'O';
            }
        }
    }

    private void secure(char[][]board,int r, int c){
        if( r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] != 'O') return;

        board[r][c] = 'T';
        for(int[] dir : dirs){
            secure(board,r+dir[0],c+dir[1]);
        }
    }
}
