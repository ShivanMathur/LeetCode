class Solution {
    public String removeDuplicates(String s, int k) {

        /* Approach 3: Using Recursion -- Time Limit Exceeded
            TC: O(n)
            SC: O(n)


        int count = 1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            }
            else{
                count = 1;
            }

            if(count == k){
                String reducedString = s.substring(0, i-k+1) + s.substring(i+1);
                return removeDuplicates(reducedString, k);
            }
        }

        return s;
        */

        /*Approach 2: Using 1 Stack
            TC: O(n)
            SC: O(n)
        */

        Stack<int[]> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek()[0] == ch){
                stack.peek()[1]++;
            }
            else{
                stack.push(new int[]{ch, 1});
            }

            if(stack.peek()[1] == k){
                stack.pop();
            }
        }

        StringBuilder result = new StringBuilder();

        while(!stack.isEmpty()){
            int[] top = stack.pop();
            while(top[1]-- > 0){
                result.append((char)top[0]);
            }
        }

        return result.reverse().toString();

        
        /* Approach 1: Using 2 Stacks -- Time Limit Exceeded
            TC: O(n * k)
            SC: O(n)
        

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            Stack<Character> tempStack = new Stack<>();

            tempStack.push(ch);

            while(!stack.isEmpty() && stack.peek() == tempStack.peek()){
                tempStack.push(stack.pop());
            }
            if(tempStack.size() != k){
                while(!tempStack.isEmpty()){
                    stack.push(tempStack.pop());
                }
            }
        }

        StringBuilder result = new StringBuilder();

        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        return result.reverse().toString();
        */
    }
}