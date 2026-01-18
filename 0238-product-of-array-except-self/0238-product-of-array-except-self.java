class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        /* Approach 2: Prefix and Suffix Product Array Approach (Optimal; without extra space)
            TC: O(N)
            SC: O(1)
        */

        int n = nums.length;

        int[] result = new int[n];

        // Compute Prefix Product
        result[0] = 1;
        for(int i=1; i<n; i++){
            result[i] = result[i-1] * nums[i-1];
        }

        int suffix = 1;
        for(int i=n-1; i>=0; i--){
            result[i] = result[i] * suffix;
            suffix = suffix * nums[i]; 
        }

        return result;

        
        /* Approach 1: Using Prefix and Suffix Product Arrays
            TC: O(n)
            SC: O(n)

        
        int n = nums.length;

        // Computing Prefix Product
        int[] prefixProduct = new int[n];
        prefixProduct[0] = 1;
        for(int i=1; i<n; i++){
            prefixProduct[i] = prefixProduct[i-1] * nums[i-1];
        }

        // Computing Suffix Product
        int[] suffixProduct = new int[n];
        suffixProduct[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            suffixProduct[i] = suffixProduct[i+1] * nums[i+1];
        }

        // Computing resultant array
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i] = prefixProduct[i] * suffixProduct[i];
        }

        return result;
        */
    }
}