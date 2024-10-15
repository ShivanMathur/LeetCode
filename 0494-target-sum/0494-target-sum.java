class Solution {
    static int mod = (int) (Math.pow(10, 9) + 7);

    public int findTargetSumWays(int[] nums, int target) {
        int totSum = 0;
        for(int i=0; i<nums.length; i++){
            totSum += nums[i];
        }

        if((totSum - target) < 0 || (totSum - target)%2 != 0){
            return 0;
        }

        int requiredTarget = (totSum - target) / 2;

        int[][] dp = new int[nums.length][requiredTarget + 1];

        if(nums[0] == 0){
            dp[0][0] = 2;
        }
        else{
            dp[0][0] = 1;
        }

        if(nums[0] != 0 && nums[0] <= requiredTarget){
            dp[0][nums[0]] = 1;
        }

        for(int ind = 1; ind<nums.length; ind++){
            for(int tar = 0; tar <= requiredTarget; tar++){
                int notTake = dp[ind-1][tar];
                
                int take = 0;
                if(nums[ind] <= tar){
                    take = dp[ind-1][tar - nums[ind]];
                }

                dp[ind][tar] = (take + notTake) % mod;
            }
        }

        return dp[nums.length - 1][requiredTarget];
    }
}