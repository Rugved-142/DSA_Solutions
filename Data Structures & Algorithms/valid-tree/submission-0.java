class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n - 1) return false;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        Set<Integer> visited = new HashSet<>();

        if(!dfs(adj,0,-1,visited)) return false;

        return visited.size() == n;
    }

    private boolean dfs(List<List<Integer>> adj, int node, int prev, Set<Integer> visited){
        if(visited.contains(node)) return false;

        visited.add(node);

        for(int list : adj.get(node)){
            if(list == prev) continue;
            if(!dfs(adj,list,node,visited)) return false;
        }

        return true;
    }
}
