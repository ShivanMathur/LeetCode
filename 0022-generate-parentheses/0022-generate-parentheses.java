class Solution {
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
}