class Solution {
    static final int MOD = 1000000007;
    public int solve(int indx,int prev1,int prev2,int prev3,int n,int[][][][] dp){
        if(indx ==n){
            return 1;
        }
        if(dp[indx][prev1+1][prev2+1][prev3+1] != -1){
            return dp[indx][prev1+1][prev2+1][prev3+1];
        }
        int ans =0;
        for(int c1=0;c1<3;c1++){
            for(int c2=0;c2<3;c2++){
                for(int c3=0;c3<3;c3++){
                    if(c1!=c2 && c2!=c3 && prev1!=c1 && prev2!=c2 && prev3 != c3){
                        ans = (ans+solve(indx+1,c1,c2,c3,n,dp)) % MOD ;
                    }
                }
            }
        }
        return dp[indx][prev1+1][prev2+1][prev3+1] = ans;
    }
    public int numOfWays(int n) {
        int[][][][] dp = new int[n+1][4][4][4];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<4;j++){
                for(int k=0;k<4;k++){
                    for(int l=0;l<4;l++){
                        dp[i][j][k][l]= -1;
                    }
                }
            }
        }

        return solve(0,-1,-1,-1,n,dp);
    }
}