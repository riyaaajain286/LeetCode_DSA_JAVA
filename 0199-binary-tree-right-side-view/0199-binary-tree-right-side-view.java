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
    //dfs
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        return dfs(root,0,list);
    }
    private List<Integer> dfs(TreeNode root,int level,List<Integer> list){
        if(root==null) return list;
        if(list.size()==level){
            list.add(root.val);
        }
        dfs(root.right,level+1,list);
        dfs(root.left,level+1,list);
        return list;
    }
}