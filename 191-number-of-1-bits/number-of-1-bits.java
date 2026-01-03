class Solution {
    public int hammingWeight(int n) {
        if(n==0){
            return 0;
        }
        int num = n;
        int count =0;
        while(num>1){
            int rem = num%2;
            if(rem == 1){
                count++;
            }
            num /= 2;
        }
        return count+1;
    }
}