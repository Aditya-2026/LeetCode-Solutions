class Solution {
    public int countBinarySubstrings(String s) {
        int zeros = 0;
        int ones = 0;
        int ans = 0;
        if(s.charAt(0) == '1'){
            ones++;
        }else{
            zeros++;
        }

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)== s.charAt(i-1)){
                if(s.charAt(i) == '1'){
                    ones++;
                }else{
                    zeros++;
                }
            }else{
                ans += Math.min(zeros,ones);
                if(s.charAt(i) == '0'){
                    zeros = 1;
                }else{
                    ones = 1;
                }
            }
        }

        ans += Math.min(zeros,ones);
        return ans;
    }
}