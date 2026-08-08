class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), res, 0);

        return res;
    }

    private void backtrack(int[] nums, List<Integer> subset, List<List<Integer>> res, int idx){
        if(idx >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        } 

        subset.add(nums[idx]);
        backtrack(nums, subset, res, idx+1);
        subset.remove(subset.size()-1);
        backtrack(nums, subset, res, idx+1);
    }
}
