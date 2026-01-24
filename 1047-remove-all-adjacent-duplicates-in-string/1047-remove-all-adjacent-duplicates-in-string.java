class Solution {
    public String removeDuplicates(String s) {
        /* Approach 1: Stack
            TC: O(n)
            SC: O(n - d); D is the total length for all duplicates
        */

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(stack.isEmpty() || stack.peek() != s.charAt(i) ){
                stack.push(s.charAt(i));
            }
            else{
                stack.pop();
            }
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}