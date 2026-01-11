class Solution {
    public static int helper(int indx,int d,int n,int[] jobDifficulty,int[][] dp){
        if(dp[indx][d] != -1){
            return dp[indx][d];
        }

        if(d == 1){
            int maxD = 0;
            for(int i = indx;i<n;i++){
                maxD = Math.max(maxD,jobDifficulty[i]);
            }

            return dp[indx][d] = maxD;
        }
        int ans = Integer.MAX_VALUE;
        int max = jobDifficulty[indx];
        for(int i=indx;i<=n-d;i++){
            max = Math.max(max,jobDifficulty[i]);
            int result = max + helper(i+1,d-1,n,jobDifficulty,dp);
            ans = Math.min(ans,result);
        }

        return dp[indx][d] = ans;
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(d>n){
            return -1;
        }
        int dp[][] = new int[n][d+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return helper(0,d,n,jobDifficulty,dp);
    }
}