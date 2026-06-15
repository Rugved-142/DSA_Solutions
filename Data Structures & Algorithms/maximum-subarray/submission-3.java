class Solution {
    public int maxSubArray(int[] nums) {
        int sum =0;
        int max = Integer.MIN_VALUE;
        int left =0;
        int right =0;
        while(right < nums.length){
            sum += nums[right];
            max = Math.max(max,sum);
            if(sum < 0) {
                left = right;
                sum = 0;
            }
            right++;
        }
        return max;
    }
}
