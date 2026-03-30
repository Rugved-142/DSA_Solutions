/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            for(int i=q.size();i>0;i--){
                TreeNode temp=q.poll();
                if(temp!=null){
                    subList.add(temp.val);
                    q.add(temp.left);
                    q.add(temp.right);
                }
            }
            if(subList.size()> 0)
                list.add(subList);
        }
        return list;
    }
}
