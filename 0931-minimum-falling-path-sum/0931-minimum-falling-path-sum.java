class Solution {
    public int minFallingPathSum(int[][] matrix) {
        /* DP: Memoization Approach */
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int minSum = Integer.MAX_VALUE;
        for(int col=0; col<n; col++){
            int tempAns = minFallingPathSumHelper(n-1, col, matrix, dp);
            minSum = Math.min(minSum, tempAns);
        }
        return minSum;
    }

    private int minFallingPathSumHelper(int row, int col, int[][] matrix, int[][] dp){
        if(col < 0 || col >= matrix.length){
            return (int)Math.pow(10, 9);
        }

        if(row == 0){
            return matrix[row][col];
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int up = matrix[row][col] + minFallingPathSumHelper(row-1, col, matrix, dp);
        int left_diag = matrix[row][col] + minFallingPathSumHelper(row-1, col-1, matrix, dp);
        int right_diag = matrix[row][col] + minFallingPathSumHelper(row-1, col+1, matrix, dp);

        dp[row][col] = Math.min(up, Math.min(left_diag, right_diag));
        
        return dp[row][col];
    }
}