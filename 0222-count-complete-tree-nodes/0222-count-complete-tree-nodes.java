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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int lh=getLeftHeight(root);
        int rh=getRightHeight(root);
       // If both heights are equal,
        // the tree is a perfect binary tree
        if(lh==rh)
           return (1<<lh)-1;//leftshift=math.power
        
        // Otherwise, count both subtrees recursively
        return 1+countNodes(root.left)+countNodes(root.right);

    }
    private int getLeftHeight(TreeNode root){
        int height=0;
        while(root!=null){
            height++;
            root=root.left;
        }
        return height;
    }
     private int getRightHeight(TreeNode root){
        int height=0;
        while(root!=null){
            height++;
            root=root.right;
        }
        return height;
    }

}