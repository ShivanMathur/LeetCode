class Solution {
    public List<String> generateParenthesis(int n) {
        /* Recursion: Better Approach
            TC: O(2^2n)
            SC: O(2n)
        
        Intuition: If the openCount (open bracket count) goes beyond N or the closeCount is greater than openCount, then no need to generate further. It will always be invalid.

        Otherwise, it will be valid string.
        */

        int openCount = 0;
        int closeCount = 0;
        List<String> result = new ArrayList<>();

        backtrack(result, "", openCount, closeCount, n);

        return result;
    }

    public void backtrack(List<String> result, String str, int openCount, int closeCount, int n){
        if(str.length() == 2*n){
            result.add(str);
            return;
        }

        if(openCount < n){
            backtrack(result, str + "(", openCount + 1, closeCount, n);
        }

        if(closeCount < openCount){
            backtrack(result, str + ")", openCount, closeCount + 1, n);
        }
    }

    /* Recursion Approach
        TC: O(2^2n * 2n)
        SC: O(2n) {Depth of Recursion Tree}
    
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", n);
        return result;
    }

    public void backtrack(List<String> result, String str, int n){
        if(str.length() == 2*n){
            if(isValid(str)){
                result.add(str);
            }
            return;
        }

        backtrack(result, str + "(", n);
        backtrack(result, str + ")", n);        
    }

    private boolean isValid(String str){
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                count++;
            }
            else{
                count--;
            }
            if(count < 0){
                return false;
            }
        }

        return count == 0;
    }

    */
}