class Solution {
    public int minIncrementForUnique(int[] nums) {
        /* Approach 1: Sorting
            TC: O(nlogn)
            SC: O(1)
        */

        if(nums.length <= 1){
            return 0;
        }

        Arrays.sort(nums);
        int moves = 0;

        for(int i=1; i<nums.length; i++){
            if(nums[i-1] == nums[i]){
                nums[i] = nums[i] + 1;
                moves += 1;
            }
            else if(nums[i-1] > nums[i]){
                moves += (nums[i-1] - nums[i]) + 1;
                nums[i] = nums[i-1] + 1;
            }
        }

        return moves;
    }
}