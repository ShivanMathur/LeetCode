class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        // Option 1: Include the 1st and Exclude the last house
        int includeFirst = rob(nums, 0, nums.length-2);

        // Option 2: Exclude the 1st and Include the last house
        int includeLast = rob(nums, 1, nums.length-1);

        return Math.max(includeFirst, includeLast);
    }

    private int rob(int [] nums, int startIndex, int endIndex){

        int[] dp = new int[nums.length];

        // Base Case
        dp[startIndex] = nums[startIndex];

        for(int i=startIndex+1; i<=endIndex; i++){
            int pick = nums[i];
            if(i > startIndex+1){
                pick += dp[i-2];
            }

            int notpick = dp[i-1];

            dp[i] = Math.max(pick, notpick);
        }

        return dp[endIndex];
    }
}