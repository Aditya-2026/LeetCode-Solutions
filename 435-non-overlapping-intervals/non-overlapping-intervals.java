class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n<=1){
            return 0;
        }
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int remove =0;
        int lastEnd = intervals[0][1];

        for(int i=1;i<n;i++){
            int currStart = intervals[i][0];
            if(currStart<lastEnd){
                remove++;
            }else{
                lastEnd = intervals[i][1];
            }
        }
        return remove;
    }
}