class Solution {
    public int maxArea(int[] nums) {
        int max_area=0;
        int left = 0;
        int right = nums.length -1;
        while(left < right){
            int height = nums[left]<nums[right] ? nums[left] : nums[right];
            int curr_area=height *(right -left);
            max_area = Math.max(curr_area,max_area);
            if(nums[left]<nums[right])
                left++;
            else
                right--;
        }
        return max_area;
    }
}
