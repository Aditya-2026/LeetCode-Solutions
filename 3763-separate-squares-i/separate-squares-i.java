class Solution {
    public boolean check(double y,int[][] squares,double totalArea){
        double belowArea = 0;
        for(int[] square : squares){
            double Y = square[1];
            double side = square[2];
            if(Y<y){
                if(y>(Y+side)){
                    belowArea += (side * side);
                }else{
                    belowArea += ((y-Y) * side);
                }
            }
        }
        return belowArea < totalArea/2;
    }
    public double separateSquares(int[][] squares) {
        double low = 0;
        double high = 0;
        double totalArea = 0;

        for(int[] square : squares){
            double y = square[1];
            double side = square[2];
            totalArea += side * side;
            high = Math.max(high,y+side);
        }

        while(high-low >= 1e-6){
            double mid = (low+high)/2;
            
            if(check(mid,squares,totalArea)){
                low = mid;
            }else{
                high = mid;
            }
        }
        return low;
    }
}