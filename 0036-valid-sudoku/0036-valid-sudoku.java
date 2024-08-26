class Solution {

    /* Brute Force Validate Grid function */
    private boolean validateGrid(char[][] board, int startRow, int endRow, int startCol, int endCol){
        HashSet<Character> grid = new HashSet<>();

        for(int i=startRow; i<=endRow; i++){
            for(int j=startCol; j<=endCol; j++){
                if(board[i][j] != '.' && !grid.add(board[i][j])){
                    return false;
                }
            }
        }

        return true;
    }
    public boolean isValidSudoku(char[][] board) {

        /* Brute Force Apprach */

        // Validate Rows
        for (int row = 0; row < 9; row++) {
            HashSet<Character> rowSet = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.' && !rowSet.add(board[row][col])) {
                    return false;
                }
            }
        }

        // Validate Columns
        for (int col = 0; col < 9; col++) {
            HashSet<Character> colSet = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                if (board[row][col] != '.' && !colSet.add(board[row][col])) {
                    return false;
                }
            }
        }

        // Validate Grid
        for(int startRow = 0; startRow < 9; startRow += 3){
            int endRow = startRow+2;
            for(int startCol = 0; startCol < 9; startCol += 3){
                int endCol = startCol+2;

                if(!validateGrid(board, startRow, endRow, startCol, endCol)){
                    return false;
                }
            }
        }

        return true;

        /*
         * Optimized Approach
         * for(int row=0; row < board.length; row++){
         * HashSet<Character> rowSet = new HashSet<>();
         * HashSet<Character> colSet = new HashSet<>();
         * HashSet<Character> cube = new HashSet<>();
         * 
         * for(int col=0; col<board[0].length; col++){
         * if(board[row][col] != '.' && !rowSet.add(board[row][col])){
         * return false;
         * }
         * if(board[col][row] != '.' && !colSet.add(board[col][row])){
         * return false;
         * }
         * int rowIndex = row/3;
         * int colIndex = col/3;
         * 
         * }
         * }
         */
    }
}