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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<TreeNode> list=new ArrayList<>();
        inorder(root,list);
       TreeNode tree=maketree(0,list.size()-1,list);
        // int ans=height(tree);
        return tree;
        
    }
    // public int height(Node root){
    //     if(root==null){
    //         return 0;
    //     }
    //     int leftheight=height(root.left);
    //     int rightheight=height(root.right);
    //     return 1+(Math.max(leftheight,rightheight));
    // }
    public TreeNode maketree(int start,int end,ArrayList<TreeNode> list){
        if(start> end) return null; //base condition

        int mid=start+(end-start)/2;
        TreeNode rootnode=new TreeNode(list.get(mid).val);

        rootnode.left=maketree(start,mid-1,list);
        rootnode.right=maketree(mid+1,end,list);
        return rootnode;
    }
    public void inorder(TreeNode root,ArrayList<TreeNode> list){
        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root);
        inorder(root.right,list);
    }
}