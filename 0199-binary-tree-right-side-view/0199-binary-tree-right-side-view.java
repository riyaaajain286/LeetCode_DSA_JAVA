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
    //DFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=dfs(root,0,new ArrayList<>());
        return ans;
    }
    public List<Integer> dfs(TreeNode root,int level,List<Integer> ans){
       if(root==null) return ans;
       if(level==ans.size())
        ans.add(root.val);
        dfs(root.right,level+1,ans);
        dfs(root.left,level+1,ans);
        return ans;
    }
}