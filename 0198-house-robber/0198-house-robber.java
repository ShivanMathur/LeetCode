class Solution {
    public int rob(int[] nums) {
        /* DP: Memoization 
        TC: O(N)
        SC: O(N) + O(N)
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return rob(nums, nums.length - 1, dp); */

        /* DP: Tabulation 
        TC: O(N)
        SC: O(N) 
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for(int i=1; i<nums.length; i++){
            int pick = nums[i];
            if(i>1){
                pick += dp[i-2];
            }

            int notpick = dp[i-1];

            dp[i] = Math.max(pick, notpick);
        }

        return dp[nums.length-1]; */

        /* DP: Space Optimization 
        TC: O(N)
        SC: O(1) */

        int prev = nums[0];
        int prev2 = 0;

        int[] dp = new int[nums.length];

        for(int i=1; i<nums.length; i++){
            int pick = nums[i];
            if(i>1){
                pick += prev2;
            }

            int notpick = prev;

            int curr = Math.max(pick, notpick);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    private int rob(int[] nums, int index, int[] dp){
        if(index < 0){
            return 0;
        }
        if(index == 0){
            return nums[index];
        }

        if(dp[index] != -1){
            return dp[index];
        }

        int pick = nums[index] + rob(nums, index-2, dp);
        int notpick = rob(nums, index-1, dp);

        dp[index] = Math.max(pick, notpick);
        return dp[index];
    }
}