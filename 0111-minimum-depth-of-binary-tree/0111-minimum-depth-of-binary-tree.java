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
    public int minDepth(TreeNode root) {
        //base case
        if(root==null) return 0;
        //calc leftsubtree and rightsubtree height 
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        //if one subtree is missing take other one coz we need leaf
        if(left==0 || right==0)
          return Math.max(left,right)+1;
          //otherwise return min depth when both subtree available
        return 1+Math.min(left,right);
    }
}