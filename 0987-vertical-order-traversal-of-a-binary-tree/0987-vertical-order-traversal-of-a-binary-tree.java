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
        if(root==null) return result;
        // pq is used for sorting answer as required in question
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            if(a.col!=b.col)
              return Integer.compare(a.col,b.col);
            else if(a.row!=b.row)
              return Integer.compare(a.row,b.row);
            else
              return Integer.compare(a.node.val,b.node.val);
        }
        );
        //q is used for bfs traversal
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0,0));
       
        while(!q.isEmpty()){
          Pair p=q.poll();
          pq.offer(p);//add each pair in pq
          if(p.node.left!=null){
            q.offer(new Pair(p.node.left,p.row+1,p.col-1));
          }
          if(p.node.right!=null){
            q.offer(new Pair(p.node.right,p.row+1,p.col+1));
          }
        }
          int prevCol=Integer.MIN_VALUE;
          List<Integer> currCol=new ArrayList<>();
          while(!pq.isEmpty()){
            Pair curr=pq.poll();
             if(curr.col!=prevCol){
                if(!currCol.isEmpty())//if current col list is filled
                  result.add(currCol);
                prevCol=curr.col;
                currCol=new ArrayList<>();//otherwise make new list
             }
             currCol.add(curr.node.val);
          }
          result.add(currCol);
        
        return result;
    }
}