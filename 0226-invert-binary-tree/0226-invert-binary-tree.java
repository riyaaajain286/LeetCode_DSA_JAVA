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
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode currentnode=q.poll();
        // swap children
            TreeNode temp=currentnode.left;
            currentnode.left=currentnode.right;
            currentnode.right=temp;
            if(currentnode.left!=null){
                q.offer(currentnode.left);
            }
             if(currentnode.right!=null){
                q.offer(currentnode.right);
            }

        }
        return root;
    }
}