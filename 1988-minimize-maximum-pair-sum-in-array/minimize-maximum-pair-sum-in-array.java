class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int maxSum = 0;

        for(int i=0;i<n/2;i++){
            int pairSum = nums[i] + nums[n-i-1];
            maxSum = Math.max(maxSum, pairSum);
        }

        return maxSum;
    }
}