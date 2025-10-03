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
    public int findBottomLeftValue(TreeNode root) {
         int ans=-1;
        if(root==null){
            return ans;
        }
    
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            ans=node.val;
            if(node.right!=null){
                queue.offer(node.right);
            }
            if(node.left!=null){
                queue.offer(node.left);
            }
        }
        return ans;
    }
}