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
    public boolean isBalanced(TreeNode root) {
      int height=heightcheck(root);
      if(height!=-1)
        return true;
      return false;
    }
    public int heightcheck(TreeNode root){
        if(root ==null) return 0;
        int leftheight=heightcheck(root.left);
        if (leftheight==-1) return -1;
        int rightheight=heightcheck(root.right);
        if(rightheight==-1) return -1;
       if(Math.abs(leftheight-rightheight)>1)  return -1;
       return 1+Math.max(leftheight,rightheight);
    }
}