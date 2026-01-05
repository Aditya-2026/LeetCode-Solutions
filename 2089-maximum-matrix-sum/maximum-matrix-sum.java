class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        int negativeCount = 0;
        long sum = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]<0){
                    negativeCount++;
                    int absVal = Math.abs(matrix[i][j]);
                    sum += absVal;
                    min = Math.min(min,absVal);
                }else{
                    sum += matrix[i][j];
                    min = Math.min(min,matrix[i][j]);
                }
            }
        }

        if((negativeCount & 1)==1){
            sum -= (2*min);
        }
        return sum;
    }
}