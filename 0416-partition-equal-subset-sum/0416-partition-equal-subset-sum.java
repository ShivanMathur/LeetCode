class Solution {
    public boolean canPartition(int[] nums) {
        /* DP: Memoization Approach */
        int arraySum = 0;
        int n = nums.length;

        for(int i=0; i<n; i++){
            arraySum += nums[i];
        }

        if(arraySum % 2 != 0){
            return false;
        }

        arraySum = arraySum/2;
        int[][] dp = new int[n][arraySum+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return canPartitionHelper(nums, n-1, arraySum, dp);
    }

    private static boolean canPartitionHelper(int[] nums, int ind, int target, int[][] dp){
        if(target == 0){
            return true;
        }

        if(ind == 0){
            return nums[ind] == target;
        }

        if(dp[ind][target] != -1){
            return dp[ind][target] == 1 ? true : false;
        }

        boolean notTaken = canPartitionHelper(nums, ind - 1, target, dp);

        boolean taken = false;
        if(nums[ind] <= target){
            taken = canPartitionHelper(nums, ind - 1, target - nums[ind], dp);
        }

        dp[ind][target] = taken || notTaken ? 1 : 0;

        return taken || notTaken;
    }
}