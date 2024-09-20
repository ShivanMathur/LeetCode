class Solution {
    public int minCostClimbingStairs(int[] cost) {
        /* Recursion: 
        TC: O(2^n) 
        int n = cost.length;
        int opt1 = minCostClimbingStairsHelper_Recursion(cost, n-1);
        int opt2 = minCostClimbingStairsHelper_Recursion(cost, n-2);

        return Math.min(opt1, opt2); */

        /* DP: Memoization Approach
        TC: O(N)

        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int opt1 = minCostClimbingStairsHelper(cost, n-1, dp);
        int opt2 = minCostClimbingStairsHelper(cost, n-2, dp);

        return Math.min(opt1, opt2); */

        /* DP: Tabulation Approach
        TC: O(N)
        SC: O(N)
        
        int n = cost.length;
        int[] dp = new int[n];

        for(int i=0; i<n; i++){
            if(i < 2){
                dp[i] = cost[i];
            }
            else{
                dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
            }
        }

        return Math.min(dp[n-1], dp[n-2]); */

        /* DP: Space Optimization 
        TC: O(N)
        SC: O(1) */
        
        int n = cost.length;
        int prev2 = cost[0];
        int prev1 = cost[1];

        for(int i=2; i<n; i++){
            int curr = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return Math.min(prev2, prev1);
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