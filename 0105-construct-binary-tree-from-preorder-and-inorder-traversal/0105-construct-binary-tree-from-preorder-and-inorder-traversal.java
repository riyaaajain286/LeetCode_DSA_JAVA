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
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int index=0;
        for(int i:inorder){
        map.put(i,index++);
        }
     TreeNode root=MakeTree(preorder,0,inorder.length-1);
     return root; 
   }
  int preIndex=0;
  public TreeNode MakeTree(int[] preorder,int left,int right){
    if(left> right) return null;

   TreeNode root=new TreeNode(preorder[preIndex++]);
     //search
     int inIndex=map.get(root.val);
     root.left=MakeTree(preorder,left,inIndex-1);
     root.right=MakeTree(preorder,inIndex+1,right);
     return root;
      
  }
}