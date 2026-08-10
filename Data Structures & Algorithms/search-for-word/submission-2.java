class Solution {
        int ROW;
        int COL;
        private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        ROW = board.length;
        COL = board[0].length;
        visited = new boolean[ROW][COL];

        for(int r = 0; r < ROW ; r++){
            for(int c = 0; c < COL ; c++){
                if(wordExist(board, word, r, c, 0)) return true;
            }
        }
        return false;
    }

    private boolean wordExist (char[][] board, String word, int r, int c, int idx){
        if(idx == word.length()) return true;

        if(r < 0 || c < 0 || r >= ROW || c >= COL || board[r][c] != word.charAt(idx) || visited[r][c]) return false;

        visited[r][c] = true;
        boolean res = wordExist(board, word, r - 1, c, idx + 1) ||
                      wordExist(board, word, r, c - 1, idx + 1) ||
                      wordExist(board, word, r + 1, c, idx + 1) ||
                      wordExist(board, word, r, c + 1, idx + 1);
        visited[r][c]=false;

        return res;
    }
}
