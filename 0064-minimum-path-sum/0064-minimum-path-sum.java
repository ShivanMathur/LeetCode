class Solution {
    public int minPathSum(int[][] grid) {

        /* Approach 3: DP - Tabulation
            TC: O(m*n)
            SC: O(m*n)
        */

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j == 0){
                    dp[i][j] = grid[i][j];
                }
                else{
                    int up = i > 0 ? dp[i-1][j] : Integer.MAX_VALUE;
                    int left = j > 0 ? dp[i][j-1] : Integer.MAX_VALUE;
                    dp[i][j] = Math.min(left, up) + grid[i][j];
                }
            }
        }

        return dp[m-1][n-1];

        
        /* Approach 2: DP Memoization (Top-Down Approach)
            TC: O(m*n)
            SC: O(m*n){DP Array} + O( (m-1) + (n-1) ){Recursion stack space of path length}
        
        

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int[] temp : dp){
            Arrays.fill(temp, -1);
        }

        return minPathSumDPMemoization(m-1, n-1, grid, dp);
        */

        
        /* Approach 1: Recursion
            TC: O(2^(m+n)) {For every move, we have at most 2 options}
            SC: O(m + n) {Recursion of depth m + n}
        
        
        int m = grid.length;
        int n = grid[0].length;

        return minPathSumRecursion(m-1, n-1, grid);
        */
        
    }

    private int minPathSumDPMemoization(int row, int col, int[][] grid, int[][] dp){
        if(row == 0 && col == 0){
            return grid[col][col];
        }
        if(row < 0 || col < 0){
            return Integer.MAX_VALUE;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int left = minPathSumDPMemoization(row, col - 1, grid, dp);
        int up = minPathSumDPMemoization(row - 1, col, grid, dp);

        dp[row][col] = grid[row][col] + Math.min(left, up);

        return dp[row][col];
    }

    private int minPathSumRecursion(int row, int col, int[][] grid){
        if(row == 0 && col == 0){
            return grid[row][col];
        }
        
        if(row < 0 || col < 0){
            return Integer.MAX_VALUE;
        }

        int left = minPathSumRecursion(row - 1, col, grid);
        int up = minPathSumRecursion(row, col - 1, grid);

        return grid[row][col] + Math.min(left, up);
    }
}