class Solution {
    public String convertToTitle(int columnNumber) {
        int num = columnNumber;
        StringBuilder sb = new StringBuilder();
        while(num>0){
            num--;
            int rem = num%26;
            sb.append((char)(rem+'A'));
            num = num/26;
        }

        return sb.reverse().toString();
    }
}