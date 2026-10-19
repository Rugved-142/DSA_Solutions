class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        HashMap<Integer, List<int[]>> edges = new HashMap<>();
        for(int[] time : times){
            edges.computeIfAbsent(time[0],
            key -> new ArrayList<>())
            .add(new int[]{time[1],time[2]});
        }


        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0,k});

        HashSet<Integer> visited = new HashSet<>();

        int t=0;

        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int weight = curr[0] , node = curr[1];
            if(visited.contains(node)) continue;
            visited.add(node);
            t = weight;

            if(edges.containsKey(node)){
                for(int[] next : edges.get(node)){
                    minHeap.offer(new int[]{next[1] + weight,next[0]});
                }
            }
        }
        return visited.size() == n ? t : -1;
    }
}
