class Solution {
    public int longestConsecutive(int[] nums) {

        /* Approach 2: Optimized Approach
            TC: O(n)
            SC: O(n)
        */

        if(nums.length <= 0){
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        int longestCount = 1;

        for(int key : set){
            int prevNum = key - 1;
            if(!set.contains(prevNum)){
                int currCount = 1;
                int nextNum = key;
                while(set.contains(nextNum + 1)){
                    nextNum += 1;
                    currCount++;
                } 
                longestCount = Math.max(longestCount, currCount);
            }
        }

        return longestCount;
        
        /* Approach 1: Better Approach: First Sort the array and then iterate to find LCS.
            TC: O(nlogn) {Sorting} + O(n){traverse}
            SC: O(1)


        if(nums.length <= 0){
            return 0;
        }
        
        Arrays.sort(nums);

        int lastNum = Integer.MIN_VALUE;
        int currCount = 0; // Counter for the current consecutive sequence length.
        int longestCount = 1; // Variable to store the maximum consecutive sequence length.

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
            // Update 'longestCount' with the maximum of 'longestCount' and 'currCount'.
            longestCount = Math.max(longestCount, currCount);
        }

        return longestCount;
        */
    }
}