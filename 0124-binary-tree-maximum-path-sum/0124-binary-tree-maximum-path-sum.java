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
    int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }
    public int helper(TreeNode root){
        if(root==null) return 0;

        int left=helper(root.left);
        int right=helper(root.right);
// your temp logic (path going down)
        int temp=Math.max(root.val,Math.max(left,right)+root.val);
        // your ans logic (path through node)
        int ans=Math.max(root.val+left+right,temp);
        res=Math.max(res,ans);
        return temp;
    }
}