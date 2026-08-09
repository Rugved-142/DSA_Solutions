class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        perms.add(new ArrayList<>());

        for(int num : nums){
            List<List<Integer>> new_perm=new ArrayList<>();
            for(List<Integer> p : perms){
                for(int i =0;i<=p.size();i++){
                    List<Integer> p_copy = new ArrayList<>(p);
                    p_copy.add(i,num);
                    new_perm.add(p_copy);
                }
            }
            perms=new_perm;
        }

        return perms;
    }
}
