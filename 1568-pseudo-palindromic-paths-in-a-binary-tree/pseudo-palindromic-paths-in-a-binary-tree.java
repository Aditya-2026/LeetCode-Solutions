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

    public boolean isPseudoPalindrome(int[] freq){
        int count = 0;

        for(int f : freq){
            if((f & 1) == 1){
                if(count == 1) return false;
                else count++;
            }
        }

        return true;
    }
    public int solve(TreeNode root,int[] freq){
        freq[root.val]++;

        if(root.left == null && root.right == null){
            int res = isPseudoPalindrome(freq) ? 1 : 0;
            freq[root.val]--;
            return res;
        }
        
        int left = 0;
        if(root.left != null) left = solve(root.left,freq);

        int right = 0;
        if(root.right != null) right = solve(root.right,freq);
        
        freq[root.val]--;

        return left + right;
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        int[] freq = new int[10];
        return solve(root,freq);
    }
}