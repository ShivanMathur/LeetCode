class Solution {
    public void nextPermutation(int[] nums) {
        int breakPointIndex = -1;

        // 1. Find the breaking point
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                breakPointIndex = i;
                break;
            }
        }

        // If there is no breaking point found, reverse the entire array to get the first permutation as the next
        if(breakPointIndex == -1){
            reverse(nums, 0);
            return;
        }

        // 2. Find the next big number than the number at the breakpoint index
        for(int i=nums.length-1; i>breakPointIndex; i--){
            if(nums[i] > nums[breakPointIndex]){
                int temp = nums[breakPointIndex];
                nums[breakPointIndex] = nums[i];
                nums[i] = temp;
                break;
            }
        } 

        // 3. Now, reverse the remaining array, starting from the position after the breakpointindex
        reverse(nums, breakPointIndex + 1);
    }

    public void reverse(int[] nums, int startIndex){
        for(int i = startIndex, j = nums.length-1; i<j; i++, j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}