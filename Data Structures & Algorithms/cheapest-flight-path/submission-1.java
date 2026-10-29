class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<int[]>> adj = new HashMap<>();
        for(int[] flight : flights){
            int start = flight[0];
            int end = flight[1];
            int cost = flight[2];
            adj.computeIfAbsent(start,key -> new ArrayList<>()).add(new int[]{end,cost}); 
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src,0});
        int stops = 0;
        int bestCost = Integer.MAX_VALUE;
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        while(!q.isEmpty() && stops <= k+1){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                int airport = curr[0];
                int costSoFar = curr[1];

                if(airport == dst){
                    bestCost = Math.min(bestCost,costSoFar);
                    continue;
                }
                for(int[] flight : adj.getOrDefault(airport,new ArrayList<int[]>())){
                    int dest = flight[0];
                    int cst = flight[1];
                    int newCost = costSoFar + cst;
                    if(newCost < prices[dest]){
                        prices[dest] = newCost;
                        q.add(new int[]{dest, newCost});
                    }
                }
            }
            stops++;
            }
        return bestCost == Integer.MAX_VALUE ? -1 : bestCost;
    }
}
