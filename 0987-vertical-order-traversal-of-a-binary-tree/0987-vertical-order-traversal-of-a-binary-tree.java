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
    class Pair{
        int row,col;
        TreeNode node;
        public Pair(TreeNode node,int row,int col){
            this.node=node;
            this.row=row;
            this.col=col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        //make priority queue
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->{
                if(a.col!=b.col){
                    return a.col-b.col;
                }
                if(a.row!=b.row){
                    return a.row-b.row;
                }
                return a.node.val-b.node.val;
            }
        );
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0,0));
        //bfs traversal
        while(!q.isEmpty()){
            Pair curr=q.poll();
            pq.offer(curr);//add each pair in pq
            if(curr.node.left!=null) 
              q.offer(new Pair(curr.node.left,curr.row+1,curr.col-1));
            if(curr.node.right!=null) 
              q.offer(new Pair(curr.node.right,curr.row+1,curr.col+1));
        }
          int prevcol=Integer.MIN_VALUE;
          List<Integer> currcol=new ArrayList<>();
          while(!pq.isEmpty()){
            Pair p=pq.poll();
            if(p.col!=prevcol){
                if(!currcol.isEmpty())//if current col list is finished
                 result.add(currcol);
                currcol=new ArrayList<>();//otherwise make new list 
                prevcol=p.col;
            }
            currcol.add(p.node.val);
          }
         result.add(currcol);
         return result;
        
    }
}