class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charFreq = new int[26];

        for(char ch : chars.toCharArray()){
            charFreq[ch - 'a']++;
        }

        int totalLength = 0;

        for(String word : words){
            int[] wordFreq = new int[26];

            boolean isGood = true;

            for(char ch : word.toCharArray()){
                wordFreq[ch - 'a']++;
                if(wordFreq[ch - 'a'] > charFreq[ch - 'a']){
                    isGood = false;
                    break;
                }
            }

            if(isGood){
                totalLength += word.length();
            }
        }
        
        return totalLength;
    }
}