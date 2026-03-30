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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr=root;
        TreeNode res = root;
        List<TreeNode> list1 = new ArrayList<>();
        while(curr != null){
            list1.add(curr);
            if(curr.val == p.val)
                break;
            else if(p.val > curr.val)
                curr = curr.right;
            else{
                curr = curr.left;
            }
        }
        List<TreeNode> list2 = new ArrayList<>();
        curr = root;
        while(curr != null){
            list2.add(curr);
            if(curr.val == q.val)
                break;
            else if(q.val > curr.val)
                curr = curr.right;
            else{
                curr = curr.left;
            }
        }
        int len = Math.min(list1.size(),list2.size());
        for(int i=0;i<len;i++){
            if(list1.get(i) == list2.get(i))
                res = list1.get(i);
            else
                break;
        }
        return res;
    }
}
