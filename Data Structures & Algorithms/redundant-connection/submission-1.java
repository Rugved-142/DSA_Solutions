class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0; i<= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
            boolean[] visit = new boolean[n+1];
            if(dfs(a,-1,adj,visit)) return edge;
        }
        return new int[0];
    }

    private boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visit){
        if(visit[node]) return true;

        visit[node] = true;

        for(int nei: adj.get(node)){
            if(nei == parent) continue;

            if(dfs(nei,node,adj,visit)) return true;
        }
        return false;
    }

}
