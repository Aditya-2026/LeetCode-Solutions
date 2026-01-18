class Solution {
    public int helper(int eggs,int floors,int[][] dp){
        if(floors == 0 ||eggs == 1 || floors == 1){
            return dp[eggs][floors] = floors;
        }
        if(dp[eggs][floors] != -1){
            return dp[eggs][floors];
        }
        int ans = Integer.MAX_VALUE;
        int low = 1;
        int high = floors;
        while(low<=high){
            int mid = low+(high-low)/2;
            int eggBreak = helper(eggs-1,mid-1,dp);
            int notBreak = helper(eggs,floors-mid,dp);
            int temp = 1 + Math.max(eggBreak,notBreak);
            ans = Math.min(ans,temp);

            if(eggBreak > notBreak){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return dp[eggs][floors] = ans;
    }
    public int superEggDrop(int k, int n) {
        int[][] dp= new int[k+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper(k,n,dp);
    }
}