class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int ROW,COL;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROW = heights.length;
        COL = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();

        boolean[][] pac = new boolean[ROW][COL];
        boolean[][] atl = new boolean[ROW][COL];

        for(int c = 0; c < COL ; c++){
            dfs(heights,0,c,pac);
            dfs(heights,ROW-1,c,atl);
        }
        for(int r = 0; r < ROW ; r++){
            dfs(heights,r,0,pac);
            dfs(heights,r,COL-1,atl);
        }

        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights,int r, int c,boolean[][] ocean){
        ocean[r][c]=true;
        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nr < ROW && nc >= 0 && nc < COL && heights[nr][nc] >= heights[r][c] 
            && !ocean[nr][nc]){
                dfs(heights,nr,nc,ocean);
            }
        }
    }
}
