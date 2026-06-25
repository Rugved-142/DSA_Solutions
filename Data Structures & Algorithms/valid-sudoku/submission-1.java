class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Character>> row = new ArrayList<>();
        List<HashSet<Character>> col = new ArrayList<>(); 
        List<HashSet<Character>> box = new ArrayList<>();

        for(int i=0;i< board.length ;i++){
            row.add(new HashSet<>());
            col.add(new HashSet<>());
            box.add(new HashSet<>());
        }

         for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char c = board[i][j];
                if( c == '.') continue;
                else{
                    int boxIndex = (i/3) * 3 + (j/3);
                    if(row.get(i).contains(c) || col.get(j).contains(c) || box.get(boxIndex).contains(c))
                        return false;
                    else
                    {
                        row.get(i).add(c);
                        col.get(j).add(c);
                        box.get(boxIndex).add(c);
                    }
                }
            }
         }
         return true;
    }
}
