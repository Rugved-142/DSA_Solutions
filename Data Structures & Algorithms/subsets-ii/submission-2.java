class Solution {
    Set<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        backtrack(0,nums,new ArrayList<>());

        return new ArrayList<>(res);
    }

    private void backtrack(int i, int[] nums, List<Integer> cur){
        if(i == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        backtrack(i+1,nums,cur);
        cur.remove(cur.size()-1);
        backtrack(i+1,nums,cur);
    }
}
