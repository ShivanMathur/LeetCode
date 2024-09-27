class Solution {
    public boolean canPartition(int[] nums) {
        /* DP: Memoization Approach
        TC: O(N * target)
        SC: O(N * target) + O(N) 
        
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

        return canPartitionHelper(nums, n-1, arraySum, dp); */

        /* DP: Tabulation Approach
        TC: O(N * target)
        SC: O(N * target)

        int arraySum = 0;
        int n = nums.length;

        for(int i=0; i<n; i++){
            arraySum += nums[i];
        }

        if(arraySum % 2 != 0){
            return false;
        }

        arraySum /= 2;
        boolean[][] dp = new boolean[n][arraySum + 1];

        for(int ind = 0; ind < n; ind++){
            dp[ind][0] = true;
        }

        if(nums[0] <= arraySum){
            dp[0][nums[0]] = true;
        }

        for(int ind = 1; ind<n; ind++){
            for(int target=1; target<=arraySum; target++){
                
                boolean notTaken = dp[ind-1][target];

                boolean taken = false;
                if(nums[ind] <= target){
                    taken = dp[ind-1][target - nums[ind]];
                }

                dp[ind][target] = notTaken || taken;
            }
        }

        return dp[n-1][arraySum]; */

        /* DP: Space Optimization */

        int arraySum = 0;
        int n = nums.length;

        for(int i=0; i<n; i++){
            arraySum += nums[i];
        }

        if(arraySum % 2 != 0){
            return false;
        }

        arraySum /= 2;

        boolean[] prev = new boolean[arraySum+1];

        prev[0] = true;

        if(nums[0] <= arraySum){
            prev[nums[0]] = true;
        }

        for(int ind = 1; ind < n; ind++){
            boolean[] curr = new boolean[arraySum+1];
            curr[0] = true;
            for(int target = 1; target <= arraySum; target++){
                boolean notTaken = prev[target];

                boolean taken = false;
                if(nums[ind] <= target){
                    taken = prev[target - nums[ind]];
                }

                curr[target] = notTaken || taken;
            }

            prev = curr;
        }

        return prev[arraySum];
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