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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q == null) return true;
        if(p == null || q == null) return false;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(p);
        q2.add(q);

        while(!q1.isEmpty() && !q2.isEmpty()){
            if(q1.size() != q2.size()) return false;

            for(int i=q1.size() ; i > 0 ; i--)
            {
                TreeNode pNode = q1.poll();
                TreeNode qNode = q2.poll();

                if(pNode == null && qNode==null) continue;
                if(pNode == null || qNode == null || pNode.val != qNode.val) return false;

                q1.add(pNode.left);
                q1.add(pNode.right);
                q2.add(qNode.left);
                q2.add(qNode.right);
            }
        }

        return true; 
    }
}
