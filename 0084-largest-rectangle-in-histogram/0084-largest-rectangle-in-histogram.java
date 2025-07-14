class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] NSR = getNextSmallestRight(heights);
        int[] NSL = getNextSmallestLeft(heights);

        int maxArea = 0;

        for(int i=0; i<heights.length; i++){
            int h = heights[i];
            int w = NSR[i] - NSL[i] - 1;

            maxArea = Math.max(maxArea, h*w);
        }

        return maxArea;
    }

    public int[] getNextSmallestRight(int[] heights){
        int[] nsr = new int[heights.length];

        Stack<Integer> stack = new Stack<>();

        for(int i=heights.length-1; i>=0; i--){
            if(stack.isEmpty()){
                nsr[i] = heights.length;
            }
            else{
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    nsr[i] = heights.length;
                }
                else{
                    nsr[i] = stack.peek();
                }
            }
            stack.push(i);
        }

        return nsr;
    }

    public int[] getNextSmallestLeft(int[] heights){
        int[] nsl = new int[heights.length];

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<heights.length; i++){
            if(stack.isEmpty()){
                nsl[i] = -1;
            }
            else{
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    nsl[i] = -1;
                }
                else{
                    nsl[i] = stack.peek();
                }
            }
            stack.push(i);
        }

        return nsl;
    }
}