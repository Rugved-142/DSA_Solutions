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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length ==0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int idx=-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == root.val)
            {
                idx=i;
                break;
            }
        }
        
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1 , idx+1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, idx);
        root.left = buildTree(leftPreorder,leftInorder);


        int[] rightPreorder = Arrays.copyOfRange(preorder, idx+1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, idx+1, inorder.length);
        root.right=buildTree(rightPreorder, rightInorder);

        return root;
    }
}
