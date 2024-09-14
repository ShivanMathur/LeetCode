class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        /* DP: Memoization Approach */

        int n = triangle.size();

        Integer[][] dp = new Integer[n][n];

        return minimumTotalHelper(0, 0, triangle, dp);
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