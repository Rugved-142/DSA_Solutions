class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        TreeMap<Integer, Integer> map =new TreeMap<>();

        for(int[] interval : intervals ){
            map.put(interval[0], map.getOrDefault(interval[0],0)+1);
            map.put(interval[1],map.getOrDefault(interval[1],0) - 1);
        }

        int count = 0;
        int start = -1;
        int end = 0; 

        for(int interval : map.keySet()){
            if(count == 0 ) start = interval;
            count +=map.get( interval);
            if(count == 0){
                end = interval;
                res.add(new int[]{start, end});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
