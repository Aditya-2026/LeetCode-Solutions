class Solution {
    public int solve(int indx,int[] nums,int[] dp,int n){
        if(indx>=n){
            return 0;
        }

        if(dp[indx] != -1){
            return dp[indx];
        }

        int rob = nums[indx] + solve(indx+2,nums,dp,n);

        int notRob = solve(indx+1,nums,dp,n);

        return dp[indx] = Math.max(rob,notRob); 
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(0,nums,dp,n);
    }
}