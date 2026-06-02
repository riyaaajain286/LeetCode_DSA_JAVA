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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
      if(root==null && subRoot==null) return true;
       if(root==null || subRoot==null) return false;
       if(isSame(root,subRoot)) return true;
       boolean left=isSubtree(root.left,subRoot);
       boolean right=isSubtree(root.right,subRoot);
       return left||right;

    }
    private boolean isSame(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;
        boolean left=isSame(p.left,q.left);
        boolean right=isSame(p.right,q.right);
        return left&&right;
    }
}