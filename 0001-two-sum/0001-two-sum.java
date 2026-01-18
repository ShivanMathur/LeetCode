class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        /* Approach 2: Using HashMap
            TC: O(n)
            SC: O(n)
        */

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int find = target - nums[i];
            if(map.containsKey(find)){
                return new int[]{map.get(find), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};


        /* Approach 1: Brute Force
            TC: O(n^2)
            SC: O(1)


        for(int i=0; i<nums.length - 1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
        */
    }
}