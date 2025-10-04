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
    public int maxLevelSum(TreeNode root) {
        if(root==null){
            return 0;
        }

    ArrayDeque<TreeNode> q=new  ArrayDeque<>();
    q.offer(root);
    int maxsum=root.val;
    int level=1;
    int maxlevel=1;
    while(!q.isEmpty()){
        int levelsize=q.size();
        int sum=0;
        for(int i=0;i<levelsize;i++){
         TreeNode currentnode=q.poll();
          sum+=currentnode.val;
         if(currentnode.left!=null){
            q.offer(currentnode.left);
         }
          if(currentnode.right!=null){
            q.offer(currentnode.right);
         }
        }
        if(sum>maxsum){
            maxsum=sum;
            maxlevel=level;
        }
        level++;
    }
    return maxlevel;
    }
    
}