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
    int preindex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return makeTree(preorder,inorder,0,inorder.length-1);
    }
    private TreeNode makeTree(int[] preorder, int[] inorder,int left,int right){
        if(left>right) return null;
        int rootval=preorder[preindex];
        TreeNode root=new TreeNode(rootval);
        int search=map.get(rootval);
        preindex++;
        root.left=makeTree(preorder,inorder,left,search-1);
        root.right=makeTree(preorder,inorder,search+1,right);
        return root;
    }
}