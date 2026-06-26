class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;

        int left = 0;
        int right = height.length-1;
        int sum = 0;
        int leftMax = height[left];
        int rightMax = height[right];
        while( left < right){
            if(leftMax < rightMax){
                left ++;
                leftMax = Math.max(leftMax , height[left]);
                sum += leftMax - height[left];
            }else{
                right--;
                rightMax = Math.max(rightMax,height[right]);

                sum += rightMax - height[right];
            }
        }

        return sum;
    }
}
