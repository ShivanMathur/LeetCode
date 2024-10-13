class Solution {
    public int coinChange(int[] coins, int amount) {
        /* DP: Memoization */

        int[][] dp = new int[coins.length][amount+1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int ans = coinChangeHelper(coins, amount, coins.length-1, dp);
        if (ans >= (int) Math.pow(10, 9))
            return -1;

        return ans;

    }

    private static int coinChangeHelper(int[] coins, int amount, int ind, int[][] dp){
        if(ind == 0){
            if(amount % coins[ind] == 0 ){
                return amount / coins[ind];
            }
            return (int)(Math.pow(10,9));
        }

        if(dp[ind][amount] != -1){
            return dp[ind][amount];
        }

        int notTake = coinChangeHelper(coins, amount, ind-1, dp);
        int take = Integer.MAX_VALUE;
        if(coins[ind] <= amount){
            take = 1 + coinChangeHelper(coins, amount - coins[ind], ind, dp);
        }

        return dp[ind][amount] = Math.min(notTake, take);
    }

}