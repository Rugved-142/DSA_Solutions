class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums,new ArrayList<>(),new boolean[nums.length]);
        return res;
    }
    private void backtrack(int[] nums, List<Integer> perm, boolean[] used){
        if(perm.size()==nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                perm.add(nums[i]);
                used[i]=true;
                backtrack(nums,perm,used);
                perm.remove(perm.size()-1);
                used[i]=false;
            }
        }
    }
}
