class Solution {
    public int trap(int[] height) {
        
        /* Approach 2: Optimized: Two Pointer
            TC: O(n)
            SC: O(1)
        */

        int n = height.length;
        int leftPtr = 0;
        int rightPtr = n-1;

        int leftMax = 0;
        int rightMax = 0;
        
        int total = 0;

        while(leftPtr < rightPtr){
            if(height[leftPtr] <= height[rightPtr]){
                if(height[leftPtr] < leftMax){
                    total += leftMax - height[leftPtr];
                }
                else{
                    leftMax = height[leftPtr];
                }
                leftPtr++;
            }
            else{
                if(height[rightPtr] < rightMax){
                    total += rightMax - height[rightPtr];
                }
                else{
                    rightMax = height[rightPtr];
                }
                rightPtr--;
            }
        }

        return total;
        
        /* Approach 1: Better Approach
            TC: O(N) + O(N) + O(N) = O(3N) 
                { O(2N) for computing prefixMax and suffixMax & 
                  O(N) for iterating over the array to calculate the result
                }

            SC: O(2N) {Storing prefixMax and suffixMax} 


        int n = height.length;

        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];

        // Compute prefixMax: Max height towards the left side of the current building
        prefixMax[0] = height[0];
        for(int i=1; i<n; i++){
            prefixMax[i] = Math.max(prefixMax[i-1], height[i]);
        }

        // Compute suffixMax: Max height towards the right side of the current building
        suffixMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            suffixMax[i] = Math.max(suffixMax[i+1], height[i]);
        }

        // Calculate the water trapped
        int total = 0;

        for(int i=0; i<n; i++){
            total += Math.min(prefixMax[i], suffixMax[i]) - height[i];
        }

        return total;
        */
    }
}