/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
     // Map to store parent of each node
     Map<TreeNode,TreeNode> parentmap=new HashMap<>();
     public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
         // Step 1: build parent mapping
         buildParent(root,null);
         // Step 2: BFS from target
         Queue<TreeNode> q=new LinkedList<>();
         Set<TreeNode> visited=new HashSet<>();
         q.offer(target);
         visited.add(target);
         int dist=0;
         while(!q.isEmpty()){
            int size=q.size();
            if(dist==k) break;
            for(int i=0;i<size;i++){
               TreeNode curr=q.poll();
               //left
               if(curr.left!=null && !visited.contains(curr.left)){
                q.offer(curr.left);
                visited.add(curr.left);
               }
               //right
                if(curr.right!=null && !visited.contains(curr.right)){
                q.offer(curr.right);
                visited.add(curr.right);
               }
               //parent
               TreeNode parent=parentmap.get(curr);
               if(parent!=null && !visited.contains(parent)){
                q.add(parent);
                visited.add(parent);
               }
              }
               dist++;
         }
         List<Integer> ans=new ArrayList<>();
         while(!q.isEmpty()){
            TreeNode ansnode=q.poll();
            ans.add(ansnode.val);
         }
         return ans;
        
    }
    // DFS to build parent map
    public void buildParent(TreeNode node,TreeNode parent){
        if(node==null) return;
        parentmap.put(node,parent);
        buildParent(node.left,node);
        buildParent(node.right,node);
    }
}