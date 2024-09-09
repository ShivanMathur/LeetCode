class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /* DP: Memoization Approach 
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        return uniquePathsWithObstaclesHelper(m-1, n-1, obstacleGrid, dp); */

        /* DP: Tabulation Approach */
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                else if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }
                else{
                    int up = 0, left = 0;
                    if(i>0){
                        up = dp[i-1][j];
                    }
                    if(j>0){
                        left = dp[i][j-1];
                    }
                    
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m-1][n-1];

    }

    private int uniquePathsWithObstaclesHelper(int m, int n, int[][] obstacleGrid, int[][] dp){
        if( m>=0 && n>=0 && obstacleGrid[m][n] == 1){
            return 0;
        }
        else if(m == 0 && n == 0){
            return 1;
        }
        else if(m<0 || n<0){
            return 0;
        }

        else if(dp[m][n] > 0){
            return dp[m][n];
        }

        int up = uniquePathsWithObstaclesHelper(m-1, n, obstacleGrid, dp);
        int left = uniquePathsWithObstaclesHelper(m, n-1, obstacleGrid, dp);

        dp[m][n] = up + left;

        return dp[m][n];
    }
}