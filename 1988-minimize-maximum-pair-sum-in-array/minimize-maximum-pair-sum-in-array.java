class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int maxSum = Integer.MIN_VALUE;

        for(int i=0;i<n/2;i++){
            int sum = nums[i] + nums[n-i-1];
            maxSum = Math.max(maxSum,sum);
        }

        return maxSum;
    }
}