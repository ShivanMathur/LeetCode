class Solution {
    public int[] productExceptSelf(int[] nums) {

        /*
         * Approach using Prefix and Postfix arrays
         * TC: O(N)
         * SC: O(N)

        int n = nums.length;

        int[] ans = new int[n];

        int[] prefix = new int[n+1];
        int[] postfix = new int[n+1];

        // Initializing first element of prefix array with 1
        prefix[0] = 1;
        // Initializing first element of postfix array with 1
        postfix[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        for(int i=n-2; i>=0; i--){
            postfix[i] = postfix[i + 1] * nums[i + 1];
        }

        for(int i=0; i<n; i++){
            ans[i] = prefix[i] * postfix[i];
        }

        return ans; */

        int ans[] = new int[nums.length];

        int prefix = 1;
        for(int i=0; i<nums.length; i++){
            ans[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for(int i=nums.length-1; i>=0; i--){
            ans[i] *= postfix;
            postfix *= nums[i];
        }

        return ans;
    }
}