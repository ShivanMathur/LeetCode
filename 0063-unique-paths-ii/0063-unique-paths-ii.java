class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /* DP: Memoization Approach */
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        return uniquePathsWithObstaclesHelper(m-1, n-1, obstacleGrid, dp);
    }

    private int uniquePathsWithObstaclesHelper(int m, int n, int[][] obstacleGrid, int[][] dp){
        if( m>=0 && n>=0 && obstacleGrid[m][n] == 1){
            return 0;
        }
        if(m == 0 && n == 0){
            return 1;
        }
        if(m<0 || n<0){
            return 0;
        }

        if(dp[m][n] != 0){
            return dp[m][n];
        }

        int up = uniquePathsWithObstaclesHelper(m-1, n, obstacleGrid, dp);
        int left = uniquePathsWithObstaclesHelper(m, n-1, obstacleGrid, dp);

        dp[m][n] = up + left;

        return dp[m][n];
    }
}