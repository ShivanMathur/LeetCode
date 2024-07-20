class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /* APPROACH 1
        int left = 0, right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        while(left <= right && right < nums.length){
            if((right - left) <= k){
                if(map.containsKey(nums[right])){
                    return true;
                }
                map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
                right++;
            }
            else{
                map.put(nums[left], map.get(nums[left])-1);
                map.remove(nums[left], 0);
                left++;
            }
        }
        return false; */
        
        /* APPROACH 2 */
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]) && (i-map.get(nums[i]))<=k){
                return true;
            }
            map.put(nums[i], i);
        }
        System.gc();
        return false;
    }
}