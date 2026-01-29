class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Map<Integer,Integer> map = new TreeMap<>();

        for(int coin : coins){
            map.put(coin,map.getOrDefault(coin,0) + 1);
        }

        int ans = 0;

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int x = entry.getKey() * entry.getValue();

            if(entry.getKey() <= ans+1){
                ans += x;
            }else{
                break;
            }
        }

        return ans+1;
    }
}