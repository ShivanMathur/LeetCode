class Solution {
    public int longestConsecutive(int[] nums) {
        // Better Approach : First Sort the array and then iterate to find LCS. 
        
        if(nums.length <= 0){
            return 0;
        }
        
        Arrays.sort(nums);

        int currCount = 0; // Counter for the current consecutive sequence length.
        int longestCount = 1; // Variable to store the maximum consecutive sequence length.
        int lastNum = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++){
            // If the current number is consecutive to the previous one, increment the counter.
            if(nums[i] - 1 == lastNum){
                currCount++;
                lastNum = nums[i];
            }
            // If the current number is not consecutive, update 'currCount' and 'lastNum'.
            else if(nums[i] != lastNum){
                lastNum = nums[i];
                currCount = 1;
            }

            // Update 'longest' with the maximum of 'longestCount' and 'currCount'.
            longestCount = Math.max(currCount, longestCount);
        }

        return longestCount;
    }
}