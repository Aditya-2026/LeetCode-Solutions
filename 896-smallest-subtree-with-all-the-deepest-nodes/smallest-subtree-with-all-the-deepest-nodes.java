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
    static class Node{
        TreeNode node;
        int depth;
        Node(TreeNode node,int depth){
            this.node = node;
            this.depth = depth;
        }
    }
    public Node helper(TreeNode root){
        if(root == null){
            return new Node(null,0);
        }

        Node left = helper(root.left);
        Node right = helper(root.right);

        if(left.depth > right.depth){
            return new Node(left.node,left.depth+1);
        }else if(left.depth < right.depth){
            return new Node(right.node,right.depth+1);
        }else{
            return new Node(root,left.depth+1);
        }
    }
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Node result = helper(root);
        return result.node;
    }
}