class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i];
            count += map.getOrDefault(prefixSum - k, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}