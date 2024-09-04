class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                // Computation for last cell
                if(i==m-1 && j==n-1){
                    dp[i][j] = grid[i][j];
                }
                // Computation for last row
                else if(i == m-1){
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                }

                // Computation for last column
                else if(j == n-1){
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                }

                // Otherwise
                else{
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return dp[0][0];
    }
}