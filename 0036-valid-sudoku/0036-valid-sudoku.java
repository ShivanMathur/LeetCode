class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        /* Approach: Using HashSet
            TC: O(n^2)
            SC: O(n^2)
        */

        Set<String> set = new HashSet<>();

        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                char val = board[row][col];
                if(val != '.'){
                    int square = (3 * (row/3)) + (col/3);

                    if(set.contains("r" + row + val) ||
                        set.contains("c" + col + val) ||
                        set.contains("sq" + square + val)
                        ){
                            return false;
                        }
                    else{
                        set.add("r" + row + val);
                        set.add("c" + col + val);
                        set.add("sq" + square + val);
                    }
                }
            }
        }

        return true;
    }
}