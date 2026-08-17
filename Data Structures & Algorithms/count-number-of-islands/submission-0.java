class Solution {
    private static final int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int r = 0 ; r < grid.length;r++){
            for(int c = 0 ; c < grid[0].length;c++){
                if(grid[r][c]=='1'){
                    dfs(grid,r,c);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length 
        || grid[row][col]== '0'){
            return;
        }

        grid[row][col]='0';
        for(int[] dir : directions){
            dfs(grid,row + dir[0],col+dir[1]);
        }
    }

        
                
}
