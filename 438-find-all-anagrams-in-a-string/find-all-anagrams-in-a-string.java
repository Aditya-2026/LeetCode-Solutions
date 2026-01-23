class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) return new ArrayList<>();
        
        int n = s.length();
        int m = p.length();

        int[] freqS = new int[26];
        int[] freqP = new int[26];

        for(char ch : p.toCharArray()){
            freqP[ch - 'a']++;
        }

        for(int i=0;i<m;i++){
            freqS[s.charAt(i) - 'a']++;
        }

        List<Integer> result = new ArrayList<>();
        if(Arrays.equals(freqP,freqS)) result.add(0);

        for(int i=m;i<n;i++){
            freqS[s.charAt(i) - 'a']++;
            freqS[s.charAt(i-m) - 'a']--;

            if(Arrays.equals(freqP,freqS)) result.add(i-m+1);
        }

        return result;
    }
}