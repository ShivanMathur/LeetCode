class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        /* DP: Memoization Approach 

        TC: O(N*N)
        SC: O(){Recursion Stack Space} + O(N*N){DP array}

        int n = triangle.size();

        Integer[][] dp = new Integer[n][n];

        return minimumTotalHelper(0, 0, triangle, dp); */

        /* DP: Tabulation

        TC: O(N*N)
        SC: O(N*N)

        int n = triangle.size();

        int[][] dp = new int[n][n];

        // Base Case: Fill the last row of dp array
        for(int j=0; j<n; j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        return dp[0][0]; */

        /* DP: Space Optimization
        TC: O(N*N)
        SC: O(N) */

        int n = triangle.size();
        int[] front = new int[n];
        int[] curr = new int[n];

        for(int j=0; j<n; j++){
            front[j] = triangle.get(n-1).get(j);
        }

        for(int i=n-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                int down = triangle.get(i).get(j) + front[j];
                int diagonal_down = triangle.get(i).get(j) + front[j+1];
                curr[j] = Math.min(down, diagonal_down);
            }
            front = curr;
        }

        return front[0];
    }

    private int minimumTotalHelper(int i, int j, List<List<Integer>> triangle, Integer[][] dp){
        if(i == triangle.size()-1){
            return triangle.get(i).get(j);
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        int down = minimumTotalHelper(i+1, j, triangle, dp);
        int diagonal_down = minimumTotalHelper(i+1, j+1, triangle, dp);

        dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal_down);
        return dp[i][j];
    }
}