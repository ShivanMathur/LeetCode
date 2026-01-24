class Solution {
    public int minIncrementForUnique(int[] nums) {
        /* Approach 2: Counting Sort
            TC: O(n + max value in the nums array)
            SC: O(n)
        */

        int n = nums.length;

        int max = 0;

        // Find the max value in the array to determine the range of the frequency array
        // O(n)
        for(int val : nums){
            max = Math.max(max, val);
        }

        // Create a frequency array to store the frequency of each value in nums
        // O(n)
        int[] frequency = new int[n + max];
        for(int val : nums){
            frequency[val]++;
        }

        int moves = 0;

        // Iterate over the frequency array to make all values unique
        // O(n + max)
        for(int i=0; i<frequency.length; i++){
            if(frequency[i] > 1){

                // Calculate extra occurences and carry forward to the next value
                int duplicates = frequency[i] - 1;
                frequency[i+1] += duplicates;
                frequency[i] = 1;
                moves += duplicates;
            }
        }

        return moves;


        /* Approach 1: Sorting
            TC: O(nlogn) {Sort the array}
            SC: O(1)
        

        Arrays.sort(nums);
        int moves = 0;

        for(int i=1; i<nums.length; i++){
            // Ensure each element is greater than its previous
            if(nums[i-1] >= nums[i]){
                moves += 1 + (nums[i-1] - nums[i]);

                // Set the element to be greater than its previous
                nums[i] = nums[i - 1] + 1;
            }
        }

        return moves;
        */
    }
}