class Solution {
    public int maxLength(int n,int[] bars){
        int ans = 2;
        Arrays.sort(bars);
        int count = 1;
        for(int i=1;i<bars.length;i++){
            if(bars[i] - bars[i-1] == 1){
                count++;
                ans = Math.max(ans,count+1);
            }else{
                count = 1;
            }
        }
        return ans;
    }
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int x = maxLength(n,hBars);
        int y = maxLength(m,vBars);

        int side = Math.min(x,y);

        return side*side;
    }
}