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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=null;
        for(int value:preorder){
            root=makeTree(root,value);
            
        }
        return root;
    }
    public TreeNode makeTree(TreeNode root,int value){
            if(root==null) {
                return new TreeNode(value);
            }
            if(value<root.val){
                root.left=makeTree(root.left,value);
            }
            else{
                root.right=makeTree(root.right,value);
            }
            return root;
    }
}