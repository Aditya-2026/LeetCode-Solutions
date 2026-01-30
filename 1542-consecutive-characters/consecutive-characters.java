class Solution {
    public int maxPower(String s) {
        int power = 1;
        int curr = 1;
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i-1) == s.charAt(i)){
                curr++;
                power = Math.max(power,curr);
            }else{
                curr = 1;
            }
        }
        return power;
    }
}