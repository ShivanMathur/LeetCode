class Solution {
    public int longestConsecutive(int[] nums) {
        /* Better Approach: First Sort the array and then iterate over the array to find the LCS
        if(nums.length <= 0){
            return 0;
        }
        Arrays.sort(nums);

        int count = 1, longestCount = 0;

        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                if(nums[i] == nums[i-1]+1 ){
                    count++;
                }
                else{
                longestCount = Math.max(longestCount, count);
                count = 1;
                }
            }
        }
        return Math.max(longestCount, count); */

        /* Optimized Approach */
        if(nums.length <= 0){
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();

        // Insert all the array elements into the hashset
        for(int i : nums){
            set.add(i);
        }

        int longestCount = 1;

        // Iterate though the array element
        for(int num : set){
            if(!set.contains(num-1)){
                int count = 1;
                int element = num;
                while(set.contains(element + 1)){
                    count++;
                    element += 1;
                }
                longestCount = Math.max(longestCount, count);
            }
        }

        return longestCount;
    }
}