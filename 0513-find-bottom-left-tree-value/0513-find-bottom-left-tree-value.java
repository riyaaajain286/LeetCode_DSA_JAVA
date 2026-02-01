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
    int ans,maxheight=-1;
    public int findBottomLeftValue(TreeNode root) {
        height(root,0);
        return ans;
    }
    //check height at each level in each subtree using dfs
    public void height(TreeNode node,int height){
        if(node==null){
            return ;
        }
        if(height>maxheight){
            maxheight=height;
            ans=node.val;
        }
       height(node.left,height+1);
       height(node.right,height+1);
    }
}