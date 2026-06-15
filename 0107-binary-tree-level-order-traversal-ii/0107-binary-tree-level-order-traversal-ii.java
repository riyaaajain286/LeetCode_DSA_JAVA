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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
         List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            ArrayList<Integer> levellist=new ArrayList<>();
            int levelsize=q.size();
            for(int i=0;i<levelsize;i++){
               TreeNode curr=q.poll();
               levellist.add(curr.val);
               if(curr.left!=null){
                q.add(curr.left);
               }
               if(curr.right!=null){
                q.add(curr.right);
               }
            }
            //insert at front of q to make it reverse or bottom up
            ans.add(0,levellist);
        } 
        return ans;
    }
    }
