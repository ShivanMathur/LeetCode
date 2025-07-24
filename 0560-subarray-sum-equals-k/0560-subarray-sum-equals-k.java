class Solution {
    public int subarraySum(int[] nums, int k) {
        /* 
            TC: O(N)
            SC: O(N)
        */
        int prefixSum = 0;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i];
            int remSum = prefixSum - k;
            if(map.containsKey(remSum)){
                count += map.get(remSum);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}