class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target,0,new ArrayList<>(),0);

        return res;
    }

    private void dfs(int[] nums, int target,int idx, ArrayList<Integer> cur, int total){
        if(total == target){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int j=idx;j<nums.length;j++){
            if(total + nums[j] > target) return;
            if(j > idx && nums[j]==nums[j-1]) continue;

            cur.add(nums[j]);
            dfs(nums,target,j+1, cur, total+nums[j]);
            cur.remove(cur.size()-1);
        }
    }
}
