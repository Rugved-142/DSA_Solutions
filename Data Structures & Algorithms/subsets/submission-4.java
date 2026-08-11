class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> cur = new ArrayList<>();
        backtrack(nums,cur,0);

        return res;        
    }

    private void backtrack(int[] nums, List<Integer> cur, int idx){
        if(idx >= nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[idx]);
        backtrack(nums,cur,idx+1);
        cur.remove(cur.size()-1);
        backtrack(nums,cur,idx+1);
    }
}
