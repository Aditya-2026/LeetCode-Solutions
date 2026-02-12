class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLength = 1;

        for(int i=0;i<n;i++){
            int[] freq = new int[26];

            for(int j=i;j<n;j++){
                freq[s.charAt(j) - 'a']++;
                int tar = freq[s.charAt(j) - 'a'];
                boolean check = true;

                for(int k=0;k<26;k++){
                    if(freq[k]>0 && freq[k] != tar){
                        check = false;
                        break;
                    }
                }

                if(check){
                    maxLength = Math.max(maxLength,j-i+1);
                }
            }
        }
        return maxLength;
    }
}