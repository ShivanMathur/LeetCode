class Solution {
    public int minCostClimbingStairs(int[] cost) {
        /* Recursion: 
        TC: O(2^n) 
        int n = cost.length;
        int opt1 = minCostClimbingStairsHelper_Recursion(cost, n-1);
        int opt2 = minCostClimbingStairsHelper_Recursion(cost, n-2);

        return Math.min(opt1, opt2); */

        /* DP: Memoization Approach */
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int opt1 = minCostClimbingStairsHelper(cost, n-1, dp);
        int opt2 = minCostClimbingStairsHelper(cost, n-2, dp);

        return Math.min(opt1, opt2);
    }

    // DP Memoization Helper Function
    private int minCostClimbingStairsHelper(int[] cost, int start, int[] dp){
        if(start < 0){
            return 0;
        }
        if(start == 0 || start == 1){
            return cost[start];
        }

        if(dp[start] != -1){
            return dp[start];
        }
        int oneStep = minCostClimbingStairsHelper(cost, start-1, dp);
        int twoStep = minCostClimbingStairsHelper(cost, start-2, dp);

        return dp[start] = cost[start] + Math.min(oneStep, twoStep);
    }

    // Recursion Helper Function
    private int minCostClimbingStairsHelper_Recursion(int[] cost, int start){
        if(start < 0){
            return 0;
        }
        if(start == 0 || start == 1){
            return cost[start];
        }
        int oneStep = minCostClimbingStairsHelper_Recursion(cost, start-1);
        int twoStep = minCostClimbingStairsHelper_Recursion(cost, start-2);

        return cost[start] + Math.min(oneStep, twoStep);
    }
}