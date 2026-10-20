class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];

        for(int i=0;i<=n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if(union(u,v,parent,rank)) return edge;
        }
    return new int[0];
    }
    private boolean union(int u, int v,int[] parent,int[] rank){
        int rootU = find(u,parent);
        int rootY = find(v,parent);

        if(rootU == rootY) return true;
        if(rank[rootU] > rank[rootY]){
            parent[rootY] = rootU;
            rank[rootU] += rank[rootY];
        }else{
            parent[rootU] = rootY;
            rank[rootY] += rank[rootU];
        }
        return false;
    }
    private int find(int node,int[] parent){
        if(parent[node] != node){
            return find(parent[node],parent);
        }
        return node;
    }
}
