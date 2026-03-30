class Solution {
    public int[] productExceptSelf(int[] nums) {
        int count_zero=0;
        int product=1;
        int[] res = new int[nums.length];
        for(int num : nums){
            if(num==0) count_zero++;
            else{
                product = product*num;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(count_zero > 1) res[i] = 0;
            else if(count_zero==1) {
                if(nums[i]==0) res[i]=product;  
                else{
                    res[i]=0;
                }
            }else{
                res[i]=product/nums[i];
            }
        }
        return res;
    }
}  
