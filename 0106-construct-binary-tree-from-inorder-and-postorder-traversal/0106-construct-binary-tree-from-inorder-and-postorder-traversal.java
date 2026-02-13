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
     int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    int index=0;
    for(int i:inorder){
      map.put(i,index++);
    }
    postIndex=postorder.length-1;
     TreeNode root=MakeTree(postorder,0,inorder.length-1);
     return root;  
  }
  
  public TreeNode MakeTree(int[] postorder,int left,int right){
    if(left> right) return null;

    TreeNode root=new TreeNode(postorder[postIndex--]);
     //search
     int inIndex=map.get(root.val);
     root.right=MakeTree(postorder,inIndex+1,right);
     root.left=MakeTree(postorder,left,inIndex-1);
     
     return root;
      
  }
}