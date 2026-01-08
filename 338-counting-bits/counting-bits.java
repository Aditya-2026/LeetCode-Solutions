class Solution {
    public int[] countBits(int n) {
        int[] setBits = new int[n+1];
        setBits[0] = 0;

        for(int i=1;i<=n;i++){
            setBits[i] = setBits[i>>1] + (i&1);
        }

        return setBits;
    }
}