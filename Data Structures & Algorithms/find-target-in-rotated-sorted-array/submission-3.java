class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            if(nums[left] < nums[right]){
                return binarySearch(nums,target,left,right);
            }
            int mid = left + (right-left)/2;

            if(nums[mid]==target) return mid;


            if(nums[left]<= nums[mid]){
                if(target >= nums[left] && target < nums[mid])
                    return binarySearch(nums,target,left,mid-1);
                else
                    left = mid +1;
            }
            else{
                if(target <= nums[right] && target > nums[mid])
                    return binarySearch(nums,target,mid+1,right);
                else
                    right = mid - 1; 
            }
        }
        return -1;
    }
    public int binarySearch(int[] nums, int target, int left, int right){
        while(left <= right){
            int mid = left+ (right-left)/2;

            if(nums[mid]==target) return mid;

            if(nums[mid] > target){
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return -1;
    }
}
