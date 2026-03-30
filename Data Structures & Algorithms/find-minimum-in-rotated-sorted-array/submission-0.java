class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int res = nums[0];
        while(left <= right){
            if(nums[left] < nums[right]){
                res = Math.min(res, nums[left]);
                break;
            }

            int m = left + (right - left) / 2;
            res = Math.min(res,nums[m]);
            if(nums[m] >= nums[left]){
                left =m+1;
            }else{
                right = m-1;
            }
        }
        return res;
    }
}
