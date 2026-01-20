class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            if((nums.get(i) & 1) == 0){
                ans[i] = -1;
                continue;
            }

            int lowestPower = (nums.get(i) + 1) & -(nums.get(i) + 1);
            ans[i] = nums.get(i) - (lowestPower >> 1);
        }

        return ans;
    }
}