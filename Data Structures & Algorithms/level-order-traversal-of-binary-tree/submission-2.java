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
        if(root==null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int loop = q.size();
            List<Integer> level = new ArrayList<>();

            for(int i = loop ;i>0;i--){
                TreeNode node =  q.poll();
                level.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
            }
            res.add(level);
        }

        return res;
    }
}
