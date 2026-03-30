class Solution {
    public boolean exist(char[][] board, String word) {
        int n=word.length();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(backtrack(board, word,i, j, 0)) return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word,int i,int j, int idx){
        if(idx == word.length()) return true;

        if(i<0 || j<0 || i>=board.length || j>= board[0].length || board[i][j] != word.charAt(idx)) return false;

        char temp = board[i][j];
        board[i][j] ='#';

        boolean found = backtrack(board, word, i - 1, j, idx + 1) || // Up
                        backtrack(board, word, i + 1, j, idx + 1) || // Down
                        backtrack(board, word, i, j - 1, idx + 1) || // Left
                        backtrack(board, word, i, j + 1, idx + 1);
        board[i][j]=temp;

        return found;
    }
}
