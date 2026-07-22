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
    int count = 1;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        int max = root.val;
        goodNode(root.left, max);
        goodNode(root.right,max);
        return count;
    }

    public void goodNode(TreeNode root, int max){
        if(root == null) return;
        if(max <= root.val){
            count++;
        }
        max = Math.max(max, root.val);
        goodNode(root.left,max);
        goodNode(root.right,max);
    }
}
