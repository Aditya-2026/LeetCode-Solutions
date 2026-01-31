class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length-1;
        int indx = 0;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(letters[mid] > target){
                high = mid-1;
                indx = mid;
            }else{
                low = mid+1;
            }
        }

        return letters[indx];
    }
}