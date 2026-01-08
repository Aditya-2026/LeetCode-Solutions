class Solution {
    public int[] countBits(int n) {
        int[] setBits = new int[n+1];
        setBits[0] = 0;

        for(int i=1;i<=n;i++){
            int num = i;
            int currBit = 0;
            int bitMask = 1;
            while(num>0){
                if((num&1) == 1){
                    currBit++;
                }
                num = num >> 1;
            }
            setBits[i] = currBit;
        }
        return setBits;
    }
}