class Solution {
    public int minCostClimbingStairs(int[] cost) {

        /* Approach 3: DP - Tabulation
            TC: O(n)
            SC: O(n)
        */

        int n = cost.length;
        int[] dpTab = new int[n];

        for(int i=0; i<n; i++){
            if(i < 2){
                dpTab[i] = cost[i];
            }
            else{
                dpTab[i] = cost[i] + Math.min(dpTab[i-1], dpTab[i-2]);
            }
        }

        return Math.min(dpTab[n-1], dpTab[n-2]);

        /* Approach 2: DP - Memoization
            TC: O(n)
            SC: O(n)
        

        int[] dpMemo = new int[cost.length + 1];
        Arrays.fill(dpMemo, -1);

        int option_step_0 = minCostClimbingStairsDPMemoization(0, cost, dpMemo);
        int option_step_1 = minCostClimbingStairsDPMemoization(1, cost, dpMemo);

        return Math.min(option_step_0,  option_step_1);

        */

        
        /* Approach 1: Recursion
            TC: O(2^n)
            SC: O(n)
        

        int option_step_0 = minCostClimbingStairsRecursion(0, cost);
        int option_step_1 = minCostClimbingStairsRecursion(1, cost);

        return Math.min(option_step_0, option_step_1);
        */
    }

    private int minCostClimbingStairsDPMemoization(int index, int[] cost, int[] dpMemo){
        if(index >= cost.length){
            return 0;
        }

        if(dpMemo[index] != -1){
            return dpMemo[index];
        }

        int oneStep = cost[index] + minCostClimbingStairsDPMemoization(index + 1, cost, dpMemo);
        int twoStep = cost[index] + minCostClimbingStairsDPMemoization(index + 2, cost, dpMemo);

        dpMemo[index] = Math.min(oneStep, twoStep);
        return dpMemo[index];
    }

    private int minCostClimbingStairsRecursion(int n, int[] cost){
        if( n >= cost.length){
            return 0;
        }

        int oneStep = minCostClimbingStairsRecursion(n+1, cost);
        int twoStep = minCostClimbingStairsRecursion(n+2, cost);

        return cost[n] + Math.min(oneStep, twoStep);
    }
}