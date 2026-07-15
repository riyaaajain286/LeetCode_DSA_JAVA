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
        maxPathDown(root);
        return maxsum;
    }
    private int maxPathDown(TreeNode root){
        if(root==null) return 0;
        int leftsum=Math.max(0,maxPathDown(root.left));
        int rightsum=Math.max(0,maxPathDown(root.right));
        //maximum path passing through current node 
        maxsum=Math.max(maxsum,(root.val+leftsum+rightsum));
        //return one side max side to parent
        return root.val+Math.max(leftsum,rightsum);
    }
}