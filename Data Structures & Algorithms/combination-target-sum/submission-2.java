class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        backtrack(nums, target, 0, 0, new ArrayList<>());

        return res;
    }

    private void backtrack(int[] nums, int target, int idx, int total, List<Integer> cur){
        if(total == target){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(idx >= nums.length) return;

        if(total + nums[idx] > target) return;
        cur.add(nums[idx]);
        backtrack(nums, target, idx, total + nums[idx], cur);
        cur.remove(cur.size()-1);
        backtrack(nums, target, idx+1, total, cur);
    }
}
