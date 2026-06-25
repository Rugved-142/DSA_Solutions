class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer>  set = new HashSet<>();
        int maxSize=1;
        for(int n : nums){
            set.add(n);
        }
        for(int n :  nums){
            int length = 1;
            if(!set.contains(n-1)){
                while(set.contains(n+length)) length++;
            }
            maxSize = Math.max(maxSize,length);
        }
    return maxSize;
    }
}
