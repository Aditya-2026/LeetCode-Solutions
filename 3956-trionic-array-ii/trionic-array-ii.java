class Solution {
    public long maxSumTrionic(int[] nums) {

        long ans = (long) -1e18;

        long prev = nums[0];
        int n = nums.length;

        long a = (long) -1e17;
        long b = (long) -1e17;
        long c = (long) -1e17;

        for (int i = 1; i < n; i++) {
            long newA = (long) -1e17;
            long newB = (long) -1e17;
            long newC = (long) -1e17;

            long curr = nums[i];

            if (curr > prev) {
                newA = Math.max(a, prev) + curr;
                newC = Math.max(b, c) + curr;
            } else if (curr < prev) {
                newB = Math.max(b, a) + curr;
            }

            a = newA;
            b = newB;
            c = newC;

            ans = Math.max(ans, c);
            prev = curr;
        }

        return ans;
    }
}
