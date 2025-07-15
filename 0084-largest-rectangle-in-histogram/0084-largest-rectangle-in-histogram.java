class Solution {
    public int largestRectangleArea(int[] heights) {
        /*

        TC: O()

        int[] NSR = getNextSmallestRight(heights);
        int[] NSL = getNextSmallestLeft(heights);

        int maxArea = 0;

        for(int i=0; i<heights.length; i++){
            int h = heights[i];
            int w = NSR[i] - NSL[i] - 1;

            maxArea = Math.max(maxArea, h*w);
        }

        return maxArea;
        */

        /* Optimized Apprach:
            TC: O(N){Array Traversal} + O(N){Stack Operations}
            SC: O(N) {Stack}

        */

        Stack<Integer> stack = new Stack<>();
        int n = heights.length;

        int maxArea = 0;

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                int height = heights[stack.pop()];

                int nextSmallestElement = i;
                int previousSmallestElemet = stack.isEmpty() ? -1 : stack.peek();

                int width = nextSmallestElement - previousSmallestElemet - 1;

                maxArea = Math.max(maxArea, height*width);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int height = heights[stack.pop()];

            int nextSmallestElement = n;
            int previousSmallestElemet = stack.isEmpty() ? -1 : stack.peek();

            int width = nextSmallestElement - previousSmallestElemet - 1;

            maxArea = Math.max(maxArea, height*width);
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