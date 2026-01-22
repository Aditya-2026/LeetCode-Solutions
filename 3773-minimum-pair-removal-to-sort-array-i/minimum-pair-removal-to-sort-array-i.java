class Solution {
    public boolean isSorted(List<Integer> list){
        if(list.size() == 1) return true;
        for(int i=1;i<list.size();i++){
            if(list.get(i-1) > list.get(i)){
                return false;
            }
        }
        return true;
    }
    public int minimumPairRemoval(int[] nums) {
        int count = 0;

        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        while(!isSorted(list)){
            count++;
            int min =Integer.MAX_VALUE;
            int indx = -1;
            for(int i=0;i<list.size()-1;i++){
                if(list.get(i) + list.get(i+1) < min){
                    min = list.get(i) + list.get(i+1);
                    indx = i;
                }
            }
            list.remove(indx+1);
            list.set(indx,min);
        }
        return count;
    }
}