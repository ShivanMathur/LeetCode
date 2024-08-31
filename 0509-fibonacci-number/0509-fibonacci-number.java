class Solution {
    public int fib(int n) {
        /* RECURSION Approach
        if (n <= 1){
            return n;
        }

        return fib(n-1) + fib(n-2); */

        /* Memoization Approach
        int[] dp = new int[n+1];
        return fib(n, dp); */

        /* Tabulation Approach */
        if(n <= 1){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    private int fib(int n, int[] dp){
        if(n <= 1){
            return n;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        dp[n] = fib(n-1, dp) + fib(n-2, dp);
        return dp[n];
    }
}