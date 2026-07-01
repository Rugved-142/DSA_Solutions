class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for(int i=0 ; i< matrix.length;i++){
            int left = 0;
            int right = matrix[0].length-1;
            if(target >= matrix[i][0] && target <= matrix[i][matrix[0].length-1])
                return binarySearch(matrix[i],target);
        }
        return false;
    }
    public boolean binarySearch(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while(left <= right){
                int mid = left + (right-left)/2;
                if(nums[mid] == target) return true;
                
                if(target > nums[mid]) left = mid+1;
                else right = mid - 1;
            }
            return false;
        }
}
