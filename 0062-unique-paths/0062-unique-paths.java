class Solution {
    public int uniquePaths(int m, int n) {
        /* DP: Memoization Approach
        int[][] dp = new int[m][n];

        return uniquePathsHelper(m-1, n-1, dp); */


        /* DP: Tabulation Approach */
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0){
                    dp[i][j] = 1;
                }
                if(j == 0){
                    dp[i][j] = 1;
                }
                if(i!=0 && j!=0){
                    int up = dp[i-1][j];
                    int left = dp[i][j-1];

                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m-1][n-1];
    }


    private int uniquePathsHelper(int m, int n, int[][] dp){
        if(m < 0 || n < 0){
            return 0;
        }

        else if(m == 0 && n == 0){
            return 1;
        }

        else if(dp[m][n] > 0){
            return dp[m][n];
        }
        
        int up = uniquePathsHelper(m-1, n, dp);
        int left = uniquePathsHelper(m, n-1, dp);

        dp[m][n] = up + left;

        return dp[m][n];
    }
}