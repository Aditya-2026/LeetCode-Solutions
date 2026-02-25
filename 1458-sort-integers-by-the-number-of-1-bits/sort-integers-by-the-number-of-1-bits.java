import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        List<Integer> buckets[] = new ArrayList[15];
        for(int i=0;i<15;i++){
            buckets[i] = new ArrayList<>();
        }

        for(int num : arr){
            int bits = Integer.bitCount(num);
            buckets[bits].add(num);
        }

        int index = 0;
        for(int i=0;i<15;i++){
            List<Integer> list = buckets[i];
            Collections.sort(list);

            for(int num : list){
                arr[index++] = num; 
            }
        }
        return arr;
    }
}