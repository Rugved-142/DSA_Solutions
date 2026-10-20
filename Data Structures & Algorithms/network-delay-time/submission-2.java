class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> adj = new HashMap<>();
        for(int[] time: times){
            int u = time[0];
            int v = time[1];
            int dist = time[2];
            adj.computeIfAbsent(u,key -> 
            new ArrayList<>()).add(new int[]{v,dist});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0,k});

        HashSet<Integer> visit = new HashSet<>();
        int t =0;

        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int weight = curr[0];
            int node = curr[1];
            if(visit.contains(node)) continue;
            t = weight;
            visit.add(node);
            if(adj.containsKey(node)){
                for(int[] edge: adj.get(node)){
                    minHeap.offer(new int[]{edge[1]+weight,edge[0]});
                }
            }
        }
        return visit.size() == n ? t : -1;
    }
}
