class Solution {
    public int maxLength(int n,int[] bars){
        if(n==0) return 0;

        int maxConsecutive = 1;
        Arrays.sort(bars);
        int count = 1;
        for(int i=1;i<bars.length;i++){
            if(bars[i] - bars[i-1] == 1){
                count++;
                maxConsecutive = Math.max(maxConsecutive,count);
            }else{
                count = 1;
            }
        }
        return maxConsecutive + 1;
    }
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int x = maxLength(n,hBars);
        int y = maxLength(m,vBars);

        int side = Math.min(x,y);

        return side*side;
    }
}