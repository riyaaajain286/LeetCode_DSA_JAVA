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
class BSTIterator {
     Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st=new Stack<>();
        pushLeft(root);
    }

    private void pushLeft(TreeNode node){
      while(node!=null){
        st.push(node);
        node=node.left;
      }
    }

    public int next() {
        TreeNode curr=st.pop();
        if(curr.right!=null)
          pushLeft(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() {
        if(!st.isEmpty())
          return true;
        else 
          return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */