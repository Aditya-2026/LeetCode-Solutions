class Solution {
    public boolean isMagicSqaure(int r,int c,int k,int[][] rowPrefixSum,int[][] colPrefixSum,int[][] grid){

        int sum = rowPrefixSum[r+1][c+k] - rowPrefixSum[r+1][c]; 
        for(int i=r;i<r+k;i++){
            if(rowPrefixSum[i+1][c+k] - rowPrefixSum[i+1][c] != sum){
                return false;
            }
        }

        for(int i=c;i<c+k;i++){
            if(colPrefixSum[r+k][i+1] - colPrefixSum[r][i+1] != sum){
                return false;
            }
        }
        int diag1 = 0;
        int diag2 = 0;
        for(int i=0;i<k;i++){
            diag1 += grid[r+i][c+i];
            diag2 += grid[r+i][c+k-i-1];
        }
        if((diag1 != sum) || (diag2 != sum)){
            return false;
        }
        
        return true;

    }
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] rowPrefixSum = new int[m+1][n+1];
        int[][] colPrefixSum = new int[m+1][n+1];

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                rowPrefixSum[i][j] = rowPrefixSum[i][j-1] + grid[i-1][j-1];
                colPrefixSum[i][j] = colPrefixSum[i-1][j] + grid[i-1][j-1];
            }
        }
        int maxK = Math.min(m,n);
        for(int k = maxK;k>1;k--){
            for(int r=0;r+k<=m;r++){
                for(int c=0;c+k<=n;c++){
                    if(isMagicSqaure(r,c,k,rowPrefixSum,colPrefixSum,grid)){
                        return k;
                    }
                }
            }
        }
        return 1;
    }
}