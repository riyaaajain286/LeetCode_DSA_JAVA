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
    //iterative approach using stack
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null) return result;
        Stack<TreeNode> st=new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr=st.pop();
            result.add(curr.val);
            if(curr.left!=null)
              st.push(curr.left);
            if(curr.right!=null)
              st.push(curr.right);
        }
        Collections.reverse(result);
        return result;
    }
}