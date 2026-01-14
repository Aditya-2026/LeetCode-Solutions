class Solution {
    public int partition(int low,int high,int[] nums){
        int pivot = nums[high];
        int pi = low;
        for(int i=low;i<high;i++){
            if(nums[i]>pivot){
                int temp = nums[i];
                nums[i] = nums[pi];
                nums[pi] = temp;
                pi++;
            }
        }
        nums[high] = nums[pi];
        nums[pi] = pivot;
        
        return pi;
    }
    public int findKthLargest(int[] nums, int k) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int random = low + (int)(Math.random() * (high-low + 1));

            int temp = nums[random];
            nums[random] = nums[high];
            nums[high] = temp;

            int pi = partition(low,high,nums);

            if(pi == k-1){
                return nums[pi];
            }else if(pi < k-1){
                low = pi+1;
            }else{
                high = pi-1;
            }
        }
        return -1;
    }
}