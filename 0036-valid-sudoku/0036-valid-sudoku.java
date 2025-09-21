class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();

        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                char val = board[r][c];

                if(val != '.'){
                    int square = (3 * (r/3)) + (c/3);

                    if(set.contains("r" + r + val) ||
                        set.contains("c" + c + val) ||
                        set.contains("sq" + square + val)
                    ){
                        return false;
                    }
                    else{
                        set.add("r" + r + val);
                        set.add("c" + c + val);
                        set.add("sq" + square + val);
                    }
                }
            }
        }

        return true;
    }
}