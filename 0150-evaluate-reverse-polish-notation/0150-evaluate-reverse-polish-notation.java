class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String s : tokens){
            int op1 = 0, op2 = 0;
            if(s.equals("+")){
                stack.push(stack.pop() + stack.pop()); 
            }
            else if(s.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }
            else if(s.equals("-")){
                op2 = stack.pop();
                op1 = stack.pop();
                stack.push(op1 - op2);
            }
            else if(s.equals("/")){
                op2 = stack.pop();
                op1 = stack.pop();
                stack.push(op1 / op2);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.peek();
    }
}