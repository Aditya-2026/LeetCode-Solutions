class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int maxSide=0;
        int n = bottomLeft.length;
        long area = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1 = bottomLeft[i][0];
                int y1 = bottomLeft[i][1];
                int x2 = topRight[i][0];
                int y2 = topRight[i][1];
                int x3 = bottomLeft[j][0];
                int y3 = bottomLeft[j][1];
                int x4 = topRight[j][0];
                int y4 = topRight[j][1];

                int xOverlap = Math.min(x2,x4) - Math.max(x1,x3);
                int yOverlap = Math.min(y2,y4) - Math.max(y1,y3);
                

                if(xOverlap>0 && yOverlap>0){
                    int side = Math.min(xOverlap,yOverlap);
                    area = Math.max(area,side*1L*side);
                }
            }
        }

        return area;
    }
}