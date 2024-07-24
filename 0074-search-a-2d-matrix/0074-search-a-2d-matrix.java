class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /* Approach 1 
        TC: O(N) + O(log M)
        */

        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=0; i<n; i++){
            if(matrix[i][0] <= target && matrix[i][m-1] >= target){
                // Apply Binary Search
                int low = 0, high = m-1;
                while(low <= high){
                    int mid = low + (high - low)/2;
                    if(matrix[i][mid] == target){
                        return true;
                    }
                    else if(matrix[i][mid] < target){
                        low = mid+1;
                    }
                    else{
                        high = mid-1;
                    }
                }
            }
        }

        return false;

        /* Optimal Approach 
        TC: O(log2(NxM))
        */
    }
}