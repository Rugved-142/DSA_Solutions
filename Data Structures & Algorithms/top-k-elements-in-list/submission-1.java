class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int x : nums){
            freqMap.put(x,freqMap.getOrDefault(x,0)+1);
        }

        int n = nums.length;
        List<Integer>[] bucket = new List[n+1];

        for (int num : freqMap.keySet()) {
            int freq = freqMap.get(num);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }
        List<Integer> result = new ArrayList<>();
        for(int i=n;i>=0 && result.size()<k;i--){
            if(bucket[i] !=null){
                for(int num : bucket[i]){
                    result.add(num);
                    if(result.size()==k) break;
                }
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
