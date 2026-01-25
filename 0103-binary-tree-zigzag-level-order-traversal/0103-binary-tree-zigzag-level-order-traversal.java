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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean leftToRight=true;//1st level
        while(!q.isEmpty()){
            int levelsize=q.size();
            List<Integer> eachlevel=new ArrayList<>();
            for(int i=0;i<levelsize;i++){
                TreeNode curr=q.poll();
                if(leftToRight){
                   eachlevel.add(curr.val);//add to back of list
                }
                else{
                   eachlevel.add(0,curr.val);// add to front of list
                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            result.add(eachlevel);
            leftToRight=!leftToRight;
        }
        return result;
    }
}