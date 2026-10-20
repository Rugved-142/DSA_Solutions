class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int cost = Math.abs(points[i][0]-points[j][0]) 
                + Math.abs(points[i][1]-points[j][1]);
                edges.add(new int[]{cost, i, j});
            }
        }
        edges.sort((a, b) -> a[0] - b[0]);

        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        int totalCost = 0;
        int edgesUsed = 0;
        for(int[] edge: edges){
            int cost = edge[0];
            int u = edge[1];
            int v = edge[2];
            int rootU = find(u,parent);
            int rootV = find(v,parent);
            if(rootU != rootV){
                totalCost += cost;
                edgesUsed++;
                if(rank[rootU] > rank[rootV]){
                    parent[rootV] = rootU;
                    rank[rootU] += rank[rootV];
                } else {
                    parent[rootU] = rootV;
                    rank[rootV] += rank[rootU];
                }
                if(edgesUsed == n-1) break;
            }
        }
        return totalCost;
    }
    private int find(int node, int[] parent){
        if(parent[node] != node) return find(parent[node],parent);

        return node;
    }
}
