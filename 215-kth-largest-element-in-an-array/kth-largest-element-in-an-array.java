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
    public int quickSelect(int low,int high,int k,int[] nums){
        int pi = partition(low,high,nums);
        if(pi == k-1){
            return nums[pi];
        }else if(pi<k-1){
            return quickSelect(pi+1,high,k,nums);
        }else{
            return quickSelect(low,pi-1,k,nums);
        }
    }
    public int findKthLargest(int[] nums, int k) {
       return quickSelect(0,nums.length-1,k,nums);
    }
}