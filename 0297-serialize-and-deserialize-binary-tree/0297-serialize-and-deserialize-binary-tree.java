/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        preorder(root,sb);
        return sb.toString();
    }

    private void preorder(TreeNode root,StringBuilder sb){

        if(root==null){
           sb.append("N,") ;
           return;
        }
        
        sb.append(root.val).append(",");
        preorder(root.left,sb);
        preorder(root.right,sb);


    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tree=data.split(",");
        Queue<String> q=new LinkedList<>();
        for(String s:tree){
            q.offer(s);
        }
       return buildtree(q);
    }
    private  TreeNode buildtree(Queue<String> q){
        String node=q.poll();
        if(node.equals("N")) return null;
        TreeNode newnode=new TreeNode(Integer.parseInt(node));
        newnode.left=buildtree(q);
        newnode.right=buildtree(q);
        return newnode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));