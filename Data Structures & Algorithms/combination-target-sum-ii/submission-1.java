class Solution {
List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        backtrack(nums, target, 0, 0, new ArrayList<>(),0);

        return res;
    }

    private void backtrack(int[] nums, int target, int idx, int total, List<Integer> cur, int start){
        if(total == target){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(idx >= nums.length) return;

        if(total + nums[idx] <= target && !(idx > start && nums[idx] == nums[idx-1])){
            cur.add(nums[idx]);
            backtrack(nums, target, idx+1, total + nums[idx], cur,idx+1);
            cur.remove(cur.size()-1);
        }
        backtrack(nums, target, idx+1, total, cur,start);
    }
}