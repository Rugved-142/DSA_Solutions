class Solution {
    public int countComponents(int n, int[][] edges) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
               dfs(i,visited,adj);
               count++;
            }
        }
        return count;
    }

    private void dfs(int node, Set<Integer> visited,List<List<Integer>> adj){
        visited.add(node);
        for(int list : adj.get(node)){
            if(!visited.contains(list)) dfs(list,visited,adj);
        }
    }
}
