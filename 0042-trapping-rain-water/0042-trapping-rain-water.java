class Solution {
    public int trap(int[] height) {

        /* TUF:: Better Approach
            TC: O(N) + O(N) + O(N) = O(3N) {O(2N) for computing prefixMax and suffixMax & O(N) for iterating over the array to calculate the result}

            SC: O(2N) {Storing prefixMax and suffixMax}
        */

        int n = height.length;

        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        
        // Compute prefixMax: Max height towards the left side of the current building
        prefixMax[0] = height[0];
        for(int i=1; i<n; i++){
            if(height[i] > prefixMax[i-1]){
                prefixMax[i] = height[i];
            }
            else{
                prefixMax[i] = prefixMax[i-1];
            }
        }

        // Compute suffixMax: Max height towards the right side of the current building
        suffixMax[n - 1] = height[n - 1];
        for(int i=n-2; i>=0; i--){
            if(height[i] > suffixMax[i+1]){
                suffixMax[i] = height[i];
            }
            else{
                suffixMax[i] = suffixMax[i+1];
            }
        }

        // Calculate the water trapped
        int result = 0;
        for(int i=0; i<n; i++){
            result += Math.min(prefixMax[i], suffixMax[i]) - height[i];
        }

        return result;
    }
}