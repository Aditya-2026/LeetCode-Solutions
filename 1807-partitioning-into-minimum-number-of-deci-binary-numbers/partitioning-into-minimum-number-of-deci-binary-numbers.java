class Solution {
    public int minPartitions(String n) {
        int ans = 0;
        for (int i = 0; i < n.length(); i++) {
            int digit = n.charAt(i)-'0';
            if (digit == 9) return 9;
            ans = Math.max(ans, digit);
        }
        return ans;
    }
}