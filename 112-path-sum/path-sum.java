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
    public boolean helper(TreeNode root,int target,int path){
        if(root == null) return false;
        path += root.val;
        if(root.left == null && root.right == null && path == target) return true;

        if(root.left != null && helper(root.left,target,path)) return true;
        if(root.right != null && helper(root.right,target,path)) return true;

        path -= root.val;

        return false;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int path = 0;
        return helper(root,targetSum,path);
    }
}