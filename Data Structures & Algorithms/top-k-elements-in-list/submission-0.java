class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int x : nums){
            freqMap.put(x,freqMap.getOrDefault(x,0)+1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a,b) -> freqMap.get(a) - freqMap.get(b)
        );
        for(int x : freqMap.keySet()){
            if(minHeap.size() < k){
                minHeap.add(x);
            }else{
                if(freqMap.get(x) > freqMap.get(minHeap.peek())){
                    minHeap.poll();
                    minHeap.add(x);
                }
            }
        }

        int[] result=new int[k];
        for(int i=0;i<k;i++)
            result[i]=minHeap.poll();
        return result;
    }
}
