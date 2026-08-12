class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        
        dfs(nums,new ArrayList<>(),new boolean[nums.length]);

        return res;
    }

    private void dfs(int[] nums, List<Integer> cur, boolean[] used){
        if(cur.size() == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                cur.add(nums[i]);
                used[i]=true;
                dfs(nums,cur,used);
                cur.remove(cur.size()-1);
                used[i]=false;
            }
        }
    }
}
