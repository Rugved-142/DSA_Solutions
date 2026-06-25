class Solution {
    public int maxArea(int[] nums) {
        int maxArea = 0;
        int left = 0;
        int right = nums.length -1;
        while(left < right){
            int currArea = (Math.min(nums[left],nums[right]) * (right - left));
            maxArea = Math.max(maxArea, currArea);
            if(nums[left] > nums[right]) right--;
            else if( nums[left] < nums[right]) left++;
            else {
                left++;
                right--;
            }
        }
        return maxArea;
    }
}
