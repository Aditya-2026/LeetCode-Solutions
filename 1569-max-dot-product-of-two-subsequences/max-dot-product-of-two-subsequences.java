class Solution {
    public int solve(int i,int j,int[] nums1,int[] nums2,int n,int m,int[][] dp){
        if(i==n){
            if(j==0){
                return Integer.MIN_VALUE;
            }else{
                return 0;
            }
        }
        if(j==m){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int pick_i = Integer.MIN_VALUE;
        for(int k =j;k<m;k++){
            pick_i = Math.max(pick_i,(nums1[i]*nums2[k])+solve(i+1,k+1,nums1,nums2,n,m,dp));
        }
        int notPick_i = solve(i+1,j,nums1,nums2,n,m,dp);

        return dp[i][j] = Math.max(pick_i,notPick_i);
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n][m];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,nums1,nums2,n,m,dp);
    }
}