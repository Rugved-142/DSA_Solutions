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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode pt = root;

        while(pt !=null || !st.isEmpty()){
            while(pt!=null){
                st.push(pt);
                pt=pt.left;
            }
            pt = st.pop();
            res.add(pt.val);
            pt=pt.right;
        }
        

        return res;
    }

    
}