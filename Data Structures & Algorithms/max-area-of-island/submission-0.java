class Solution {
    private static final int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int max_area = 0;

        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length ; c++){
                if(grid[r][c] == 1 )
                    max_area = Math.max(max_area,dfs(grid,r,c));
            }
        }

        return max_area;
    }

    private int dfs(int[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0){
            return 0;   
        }

        grid[row][col] = 0;

        int area = 1;
        for(int[] dir : directions){
            area += dfs(grid,row+dir[0],col+dir[1]);
        }
        return area;
    }
}
