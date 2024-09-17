class Solution {
    public int minFallingPathSum(int[][] matrix) {
        /* DP: Memoization Approach - Time Limit Exceeded if dp initialized with -1
        TC: O(N*N)
        SC: O(N*N) + O(N) 
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -100000 );
        }

        int minSum = Integer.MAX_VALUE;
        for(int col=0; col<n; col++){
            int tempAns = minFallingPathSumHelper(n-1, col, matrix, dp);
            minSum = Math.min(minSum, tempAns);
        }
        return minSum; */

        /* DP: Tabulation Approach 
        TC: O(N*N) + O(N)
        SC: O(N*N) 
        int n = matrix.length;
        int[][] dp = new int[n][n];

        // Base Case
        for(int col=0; col<n; col++){
            dp[0][col] = matrix[0][col];
        }

        for(int row = 1; row<n; row++){
            for(int col=0; col<n; col++){
                int up = dp[row-1][col];
                
                int left_diag = 100000;
                if(col-1 >=0){
                    left_diag = dp[row-1][col-1];
                }

                int right_diag = 100000;
                if(col+1 < n){
                    right_diag = dp[row-1][col+1];
                }
                dp[row][col] = matrix[row][col] + Math.min(up, Math.min(left_diag, right_diag));
            }
        }

        int ans = dp[n-1][0];
        for(int col=1; col<n; col++){
            ans = Math.min(ans, dp[n-1][col]);
        }

        return ans; */

        /* DP: Space Optimization
        TC: O(N*N)
        SC: O(N) */

        int n = matrix.length;
        int[] prevRow = new int[n];
        int[] currRow = new int[n];

        // Base Case
        for(int col=0; col<n; col++){
            prevRow[col] = matrix[0][col];
        }

        for(int row=1; row<n; row++){
            for(int col=0; col<n; col++){
                int up = prevRow[col];

                int left_diag = 100000;
                if(col-1>=0){
                    left_diag = prevRow[col-1];
                }

                int right_diag = 100000;
                if(col+1<n){
                    right_diag = prevRow[col+1];
                }

                currRow[col] = matrix[row][col] + Math.min(up, Math.min(left_diag, right_diag));
            }
            prevRow = currRow;
        }

        int ans = prevRow[0];

        for(int col=1; col<n; col++){
            ans = Math.min(ans, prevRow[col]);
        }

        return ans;

    }

    private int minFallingPathSumHelper(int row, int col, int[][] matrix, int[][] dp){
        if(col < 0 || col >= matrix.length){
            return (int)Math.pow(10, 9);
        }

        if(row == 0){
            return matrix[row][col];
        }

        if(dp[row][col] != -100000 ){
            return dp[row][col];
        }

        int up = matrix[row][col] + minFallingPathSumHelper(row-1, col, matrix, dp);
        int left_diag = matrix[row][col] + minFallingPathSumHelper(row-1, col-1, matrix, dp);
        int right_diag = matrix[row][col] + minFallingPathSumHelper(row-1, col+1, matrix, dp);

        dp[row][col] = Math.min(up, Math.min(left_diag, right_diag));
        
        return dp[row][col];
    }
}