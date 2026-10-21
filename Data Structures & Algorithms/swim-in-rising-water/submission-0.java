class Solution {
    int[][] neighbors = {{1,0},{0,1},{-1,0},{0,-1}};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        minHeap.offer(new int[]{grid[0][0],0,0});
        boolean[][] visited = new boolean[n][n];
        int t = 0;
        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int elevation = curr[0];
            int row = curr[1];
            int col = curr[2];
            t = Math.max(t,elevation);
            if(row == n-1 && col == n-1) return t;
            if(visited[row][col]) continue;
            visited[row][col] = true;
            for(int[] neighbor : neighbors){
                int newRow = row + neighbor[0];
                int newCol = col + neighbor[1];
                if(newRow < 0 || newRow >= n || newCol < 0 || newCol >=n) continue;
                if(visited[newRow][newCol]) continue;
                minHeap.offer(new int[]{Math.max(grid[newRow][newCol],elevation),newRow,newCol});
            }
        }

        return t;
    }
}
