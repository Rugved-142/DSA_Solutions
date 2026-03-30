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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root,res);

        return res;
    }

    public void traverse(TreeNode currNode, List<Integer> res){
        if(currNode == null) return;

        traverse(currNode.left,res);

        traverse(currNode.right,res);

        res.add(currNode.val);
    }
}