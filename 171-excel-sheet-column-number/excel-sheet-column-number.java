class Solution {
    public int titleToNumber(String columnTitle) {
        int pos = 1;
        int ans = 0;

        for(int i = columnTitle.length()-1;i>=0;i--){
            char ch = columnTitle.charAt(i);
            ans += pos*(ch-'A'+1);
            pos *= 26;
        }

        return ans;
    }
}