class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;

        for(int num : nums){
            int count = 0;
            int currSum = 0;
            for(int i=1;i<=Math.sqrt(num);i++){
                if(num%i==0){
                    int divisor1 = i;
                    int divisor2 = num/i;

                    if(divisor1==divisor2){
                        count++;
                        currSum += divisor1;
                    }else{
                        count += 2;
                        currSum += (divisor1+divisor2);
                    }
                }
                if(count>4){
                    break;
                }
            }
            if(count==4){
                sum += currSum;
            }
        }
        return sum;
    }
}