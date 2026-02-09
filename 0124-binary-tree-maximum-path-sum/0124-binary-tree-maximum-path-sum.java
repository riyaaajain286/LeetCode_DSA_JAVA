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
    int maxsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxsum;
    }
    public int helper(TreeNode root){
        if(root==null) return 0;
        // ignore negative paths

        int left=Math.max(0,helper(root.left));
        int right=Math.max(0,helper(root.right));
// path passing through current node
        int currpath=left+right+root.val;
         // update global maximum
        maxsum=Math.max(currpath,maxsum);
        // return path going DOWN to parent
        int temp=Math.max(left,right)+root.val;
        return temp;

    }
}