class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            int num = nums.get(i);
            if(num==2){
                ans[i] = -1;
                continue;
            }
            int d=0;
            while((num & (1 << d)) != 0){
                d++;
            }
            ans[i] = num - (1 << (d-1));
            
        }
        return ans;
    }
}