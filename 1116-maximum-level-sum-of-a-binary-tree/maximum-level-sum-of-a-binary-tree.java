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
    public int maxLevelSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level =1;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 0;
        while(true){
            TreeNode curr = q.poll();
            if(curr == null){
                if(maxSum<currSum){
                    maxSum = currSum;
                    maxLevel = level;
                }
                level++;
                currSum = 0;
                if(q.isEmpty()){
                    break;
                }
                q.offer(null);
            }else{
                currSum += curr.val;
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            
        }

        return maxLevel;
    }
}