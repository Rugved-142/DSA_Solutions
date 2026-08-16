class Solution {
    List<List<String>> res = new ArrayList<>();
    boolean[] col,posDiag,negDiag;
    public List<List<String>> solveNQueens(int n) {
        char[][] visited = new char[n][n];
        col = new boolean[n];
        posDiag = new boolean[2 * n];
        negDiag = new boolean[2 * n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                visited[i][j] = '.'; 
            }
        }
        backtrack(visited,0, n);

        return res;
    }
    
    private void backtrack(char[][] visited, int r, int n){
        if(r == n){
            List<String> cur = new ArrayList<>();
            for(char[] row : visited){
                cur.add(new String(row));
            }
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int c = 0;c<n;c++){
            if(col[c] || posDiag[r+c] || negDiag[r - c +n]) continue;
            col[c] = true;
            posDiag[r + c] = true;
            negDiag[r - c + n] = true;
            visited[r][c] = 'Q';
            backtrack(visited,r+1, n);
            col[c] = false;
            posDiag[r + c] = false;
            negDiag[r - c + n] = false;
            visited[r][c] = '.';
        }
    }
}
