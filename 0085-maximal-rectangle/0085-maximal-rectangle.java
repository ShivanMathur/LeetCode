class Solution {
    public int maximalRectangle(char[][] matrix) {
        /*
        TC: O(n*m * m)

        */
        int n = matrix.length;
        int m = matrix[0].length;

        int[] height = new int[m];

        for(int col=0; col<m; col++){
            if(matrix[0][col] == '1'){
                height[col] = 1;
            }
            else{
                height[col] = 0;
            }
        }

        int maxArea = findMaxArea(height);

        for(int row=1; row<n; row++){
            for(int col=0; col<m; col++){
                if(matrix[row][col] == '0'){
                    height[col] = 0;
                }
                else{
                    height[col] += 1;
                }
            }
            maxArea = Math.max(maxArea, findMaxArea(height));
        }

        return maxArea;
    }

    public int[] getNSR(int[] height){
        Stack<Integer> stack = new Stack<>();
        int[] nsr = new int[height.length];

        for(int i=height.length-1; i>=0; i--){
            if(stack.isEmpty()){
                nsr[i] = height.length;
            }
            else{
                while(!stack.isEmpty() && height[stack.peek()] >= height[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    nsr[i] = height.length;
                }
                else{
                    nsr[i] = stack.peek();
                } 
            }
            stack.push(i);            
        }

        return nsr;
    }

    public int[] getNSL(int[] height){
        Stack<Integer> stack = new Stack<>();
        int[] nsl = new int[height.length];

        for(int i=0; i<height.length; i++){
            if(stack.isEmpty()){
                nsl[i] = -1;
            }
            else{
                while(!stack.isEmpty() && height[stack.peek()] >= height[i]){
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

    public int findMaxArea(int[] height){
        int[] nsr = getNSR(height);
        int[] nsl = getNSL(height);

        int maxArea = 0;

        for(int i=0; i<height.length; i++){
            int h = height[i];
            int w = nsr[i] - nsl[i] - 1;
            maxArea = Math.max(maxArea, h*w);
        }

        return maxArea;
    }
}