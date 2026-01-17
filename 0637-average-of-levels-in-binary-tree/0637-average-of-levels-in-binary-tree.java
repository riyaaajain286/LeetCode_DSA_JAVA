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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result=new ArrayList<>();
         if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
          int levelsize=queue.size();
          double average=0.00;
          for(int i=0;i<levelsize;i++){
          TreeNode poppednode=queue.poll();
          average+=poppednode.val;
          if(poppednode.left!=null){
            queue.offer(poppednode.left);
            }
          if(poppednode.right!=null){
            queue.offer(poppednode.right);
          }
        }
         average/=levelsize;
          result.add(average);
        }
    return result;
    }
    
}