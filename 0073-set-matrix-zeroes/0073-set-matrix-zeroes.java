class Solution {
    public void setZeroes(int[][] matrix) {
        /* Better Approach
        TC: O(2*(M * N))
        SC: O(M) + O(N)

        int m = matrix.length;
        int n = matrix[0].length;
        
        // Keep track of the rows and columns which needs to be marked to 0's
        int[] row = new int[m];
        int [] col = new int[n];

        // Iterate over the matrix to find the cells which contains 0
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1; 
                }
            }
        }

        // Again iterate over the matrix. 
        // If any index in row or col array contains 1, we need to mark the row and column to 0
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if( row[i] == 1 || col[j] == 1 ){
                    matrix[i][j] = 0;
                }
            }
        }
        */

        /* Optimal Approach
        TC: O(2*(M * N))
        SC: O(1)
        */

        int m = matrix.length;
        int n = matrix[0].length;

        int col_0_0 = 1;

        // 1. Traverse the matrix and mark 1st row and column if it contains 0
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    if(j != 0){
                        matrix[0][j] = 0;
                    }
                    else{
                        col_0_0 = 0;
                    }
                }
            }
        }

        // 2. Mark with 0 from (1, 1) to (m-1, n-1)
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j] != 0){
                    if(matrix[i][0] == 0 || matrix[0][j] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // 3. Finally, mark the 1st column & then 1st row
        if(matrix[0][0] == 0){
            for(int j=0; j<n; j++){
                matrix[0][j] = 0;
            }
        }

        if(col_0_0 == 0){
            for(int i=0; i<m; i++){
                matrix[i][0] = 0;
            }
        }
    }
}