class Solution {
    static long MOD = 1000000007;
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

        int h[] = new int[hFences.length + 2];
        int v[] = new int[vFences.length + 2];

        h[0] = 1;
        v[0] = 1;

        for(int i=0;i<hFences.length;i++) h[i+1] = hFences[i];
        for(int i=0;i<vFences.length;i++) v[i+1] = vFences[i];

        h[h.length-1] = m;
        v[v.length-1] = n;

        Set<Integer> set = new HashSet<>();

        Arrays.sort(h);
        Arrays.sort(v);

        for(int i=0;i<h.length;i++){
            for(int j=i+1;j<h.length;j++){
                set.add(h[j] - h[i]);
            }
        }

        int max =-1;

        for(int i=0;i<v.length;i++){
            for(int j=i+1;j<v.length;j++){
                if(set.contains(v[j]-v[i])){
                    max = Math.max(max,v[j]-v[i]);
                }
            }
        }
        if(max == -1) return -1;
        return (int)(((long)max * max)%MOD);
    }
}