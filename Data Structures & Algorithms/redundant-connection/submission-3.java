class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        int[] rank = new int[edges.length+1];
        
        for(int i=0;i< parent.length ; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            if(!union(parent,rank,u,v)) return new int[]{u,v};
        }

        return new int[0];
    }

    private boolean union(int[] parent,int[] rank, int u, int v){
        int rootU = find(parent,u);
        int rootV = find(parent,v);
        
        if(rootU == rootV) return false;

        if(rank[rootU] > rank[rootV]){
            parent[rootV] = rootU;
            rank[rootU] += rank[rootV];
        }else{
            parent[rootU] = rootV;
            rank[rootV] += rank[rootU];
        }

        return true;
    }

    private int find(int[] parent, int x){
        if(parent[x] != x)
            return find(parent,parent[x]);
        
        return x;
    } 
}
