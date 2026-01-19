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
    public int[] solve(TreeNode root){
        if(root == null) return new int[2];

        int[] robLeft = solve(root.left); 
        int[] robRight = solve(root.right);

        int ways[] = new int[2];

        ways[0] = root.val + robLeft[1] +robRight[1];
        ways[1] = Math.max(robLeft[0],robLeft[1]) + Math.max(robRight[0],robRight[1]);

        return ways;
    }

    public int rob(TreeNode root) {
        int[] ways = solve(root);
        return Math.max(ways[0],ways[1]);
    }
}