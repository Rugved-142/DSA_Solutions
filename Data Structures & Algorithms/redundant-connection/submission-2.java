class Solution {
    private boolean[] visit;
    private List<List<Integer>> adj;
    private Set<Integer> cycle;
    private int cycleStart;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        adj = new ArrayList<>();
        for(int i =0; i<= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        visit = new boolean[n+1];
        cycle = new HashSet<>();
        cycleStart = -1;
        dfs(1,-1);

        for(int i = edges.length - 1; i>=0; i--){
            int u = edges[i][0];
            int v = edges[i][1];
            if(cycle.contains(u) && cycle.contains(v)) return new int[]{u,v};
        }
        return new int[0];
    }

    private boolean dfs(int node, int parent){
        if(visit[node]){
            cycleStart = node;
            return true;
        }

        visit[node] = true;

        for(int nei: adj.get(node)){
            if(nei == parent) continue;

            if(dfs(nei,node)){
                if(cycleStart != -1) cycle.add(node);

                if(node == cycleStart) cycleStart = -1;

                return true;
            }
        }
        return false;
    }
}
