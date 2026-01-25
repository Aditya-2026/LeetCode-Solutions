class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            sum += num;
            pq.offer(num);
        }

        while(k>0){
            int min = pq.poll();

            if(min >= 0){
                if((k & 1) == 1) sum -= 2 * min;
                break;
            }

            min = -min;
            sum += 2 * min;
            pq.offer(min);
            k--;
        }

        return sum;
    }
}