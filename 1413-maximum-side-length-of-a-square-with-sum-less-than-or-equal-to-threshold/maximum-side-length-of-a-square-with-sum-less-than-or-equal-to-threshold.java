class Solution {
    public boolean check(int k,int i,int j,int threshold,int[][] prefixSum){
        int n = prefixSum.length-1;
        int m = prefixSum[0].length-1;
        if(i+k>n || j+k>m){
            return false;
        }

        int sum = prefixSum[i+k][j+k] - prefixSum[i+k][j-1] - prefixSum[i-1][j+k] + prefixSum[i-1][j-1];

        return sum<=threshold;
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] prefixSum = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] =
                        prefixSum[i - 1][j]
                      + prefixSum[i][j - 1]
                      - prefixSum[i - 1][j - 1]
                      + mat[i - 1][j - 1];
            }
        }

        int ans = 0;
        int maxPossible = Math.min(n, m);

        int low = 1, high = maxPossible;

        while (low <= high) {
            int mid = (low + high) / 2;
            boolean found = false;

            for (int i = 1; i + mid - 1 <= n && !found; i++) {
                for (int j = 1; j + mid - 1 <= m; j++) {
                    int sum = prefixSum[i + mid - 1][j + mid - 1]
                            - prefixSum[i - 1][j + mid - 1]
                            - prefixSum[i + mid - 1][j - 1]
                            + prefixSum[i - 1][j - 1];

                    if (sum <= threshold) {
                        found = true;
                        break;
                    }
                }
            }

            if (found) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}