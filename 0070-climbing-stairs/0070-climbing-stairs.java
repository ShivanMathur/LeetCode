class Solution {
    
    private int[] dpMemo;

    public int climbStairs(int n) {

        /* Approach 3: DP - Tabulation
            TC: O(n)
            SC: O(n)
        */

        if(n <= 1){
            return 1;
        }

        int[] dpTab = new int[n+1];
        dpTab[0] = 1;
        dpTab[1] = 1;

        for(int i=2; i<=n; i++){
            dpTab[i] = dpTab[i-1] + dpTab[i-2];
        }

        return dpTab[n];

        
        
        /* Approach 2: DP - Memoization
            TC: O(n)
            SC: O(n)
        
        dpMemo = new int[n+1];
        return climbStairsDPMemoization(n);
        
        */

        
        /* Approach 1: Recursion
            TC: O(2^n)
            SC: O(n)

        if(n <= 1){
            return 1;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
        */
    }

    private int climbStairsDPMemoization(int n){
        if(n <= 1){
            dpMemo[n] = 1;
        }

        if(dpMemo[n] != 0){
            return dpMemo[n];
        }

        dpMemo[n] = climbStairsDPMemoization(n-1) + climbStairsDPMemoization(n-2);
        return dpMemo[n];
    }
}