class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int count = 0;
        int curr = 0;
        for(char ch : s.toCharArray()){
            if(ch - '0' == curr) count++;
            curr ^= 1;
        }

        return Math.min(count,n-count);
    }
}