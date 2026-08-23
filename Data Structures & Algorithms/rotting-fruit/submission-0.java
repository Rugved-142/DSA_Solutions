class Solution {
    public int orangesRotting(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;
        for(int r=0;r<ROW;r++){
            for(int c=0;c<COL;c++){
                if(grid[r][c] == 2)
                    q.add(new int[]{r,c});
                if(grid[r][c] == 1)
                    freshCount++;
            }
        }

        int[][] dirs = { { -1, 0 }, { 0, -1 },
                         { 1, 0 }, { 0, 1 } };
        int minute = 0;
        while(freshCount > 0 && !q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] node = q.poll();
                int row = node[0];
                int col = node[1];
                for(int[] dir : dirs){
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if(r < 0 || c < 0 || r >= ROW || c >= COL || grid[r][c] != 1) continue;
                    grid[r][c] = 2;
                    q.add(new int[]{r,c});
                    freshCount--;
                }
            }
            minute++;
        }
    return freshCount == 0 ? minute : -1;
    }
}
