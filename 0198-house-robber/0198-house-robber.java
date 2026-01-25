class Solution {
    public int rob(int[] nums) {
        
        /* Approach 3: DP - Tabulation
            TC: O(n)
            SC: O(n)
        */

        int n = nums.length;
        int[] dpTab = new int[n];
        
        dpTab[0] = nums[0];

        for(int i=1; i<n; i++){
            int pick = nums[i];
            if(i > 1){
                pick += dpTab[i-2];
            }
            int notpick = dpTab[i-1];

            dpTab[i] = Math.max(pick, notpick);
        }

        return dpTab[n-1];


        
        /* Approach 2: DP - Memoization
            TC: O(n)
            SC: O(n) + O(n)

        
        int n = nums.length;
        int[] dpMemo = new int[n];
        Arrays.fill(dpMemo, -1);

        return robDPMemo(n - 1, nums, dpMemo);
        */
        
        /* Approach 1: Recursion
            TC: O(2^n)
            SC: O(n)

        return robRecursion(nums.length - 1, nums);
        */
    }

    private int robDPMemo(int index, int[] nums, int[] dpMemo){
        if(index == 0){
            return nums[index];
        }
        if(index < 0){
            return 0;
        }

        if(dpMemo[index] != -1){
            return dpMemo[index];
        }

        int pick = nums[index] + robDPMemo(index - 2, nums, dpMemo);
        int notpick = robDPMemo(index-1, nums, dpMemo);

        dpMemo[index] = Math.max(pick, notpick);

        return dpMemo[index];
    }

    private int robRecursion(int index, int[] nums){

        if(index == 0){
            return nums[index];
        }
        if(index < 0){
            return 0;
        }

        int pick = nums[index] + robRecursion(index - 2, nums);
        int notpick = robRecursion(index - 1, nums);

        return Math.max(pick, notpick);
    }
}