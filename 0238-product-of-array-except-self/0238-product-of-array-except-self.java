class Solution {
    public int[] productExceptSelf(int[] nums) {
        /* Prefix and Suffix Product Array Approach (Optimal; without extra space)
            TC: O(N)
            SC: O(1)
        */

        int n = nums.length;
        int[] ans = new int[n];

        // Computing Prefix Product
        ans[0] = 1;
        for(int i=1; i<n; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        int postfix = 1;
        for(int i=n-1; i>=0; i--){
            ans[i] = ans[i] * postfix;
            postfix = postfix * nums[i];
        }

        return ans;
        
        /* Prefix and Suffix Product Array Approach
            TC: O(N)
            SC: O(N)

        int n = nums.length;

        int[] ans = new int[n];
        int[] prefix = new int[n];
        int[] postfix = new int[n];

        // Compute Prefix Product
        prefix[0] = 1;
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        // Compute Postfix Product
        postfix[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            postfix[i] = nums[i+1] * postfix[i+1];
        }

        for(int i=0; i<n; i++){
            ans[i] = prefix[i] * postfix[i];
        }

        return ans;
        */  
    }
}