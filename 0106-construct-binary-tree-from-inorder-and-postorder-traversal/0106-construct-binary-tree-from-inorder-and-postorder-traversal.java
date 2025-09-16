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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        return helper(inorder,0,n-1,postorder,0,n-1);
    }
      public TreeNode helper(int[] inorder,int isi,int iei, int[] postorder,int psi,int pei) {
      if(isi>iei){
        return null;
      }
      int idx=isi;
      int rootval=postorder[pei];
      while(inorder[idx]!=rootval){
        idx++;
      }
      //count left subtree elements
      int colse=idx-isi;
      TreeNode node=new TreeNode(rootval);
      node.left=helper(inorder,isi,idx-1,postorder,psi,psi+colse-1);
      node.right=helper(inorder,idx+1,iei,postorder,psi+colse,pei-1);
      return node;
    }
}