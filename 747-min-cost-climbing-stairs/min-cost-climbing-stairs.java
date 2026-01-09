class Solution {
    public int helper(int step,int[] cost,int dp[]){
        if(step==0 || step==1){
            return cost[step];
        }
        if(dp[step] != -1){
            return dp[step];
        }

        int way1 = helper(step-1,cost,dp);
        int way2 = Integer.MAX_VALUE;
        if(step>1){
            way2 = helper(step-2,cost,dp);
        }

        return dp[step] = cost[step] + Math.min(way1,way2);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2;i<n;i++){
            int way1 = dp[i-1];
            int way2 = dp[i-2];

            dp[i] = cost[i] + Math.min(way1,way2);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}