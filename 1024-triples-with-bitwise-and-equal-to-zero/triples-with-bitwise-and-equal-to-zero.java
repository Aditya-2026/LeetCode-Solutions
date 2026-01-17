class Solution {
    public int countTriplets(int[] nums) {
        int n = nums.length;

        int MAX = 1 << 16;
        int[] freq = new int[MAX];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int pair = nums[i] & nums[j];
                freq[pair]++;
            }
        }

        int triplets = 0;

        for(int k=0;k<n;k++){
            for(int mask=0;mask<MAX;mask++){
                if((mask & nums[k]) == 0){
                    triplets += freq[mask];
                }
            }
        }

        return triplets;
    }
}