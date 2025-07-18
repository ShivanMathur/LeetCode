class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        int ans = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high - low)/2;

            // Optimization: If search space is already sorted, then nums[low] will always be the smaller element in the search space

            if(nums[low] <= nums[high]){
                return Math.min(ans, nums[low]);
            }

            if(nums[low] <= nums[mid]){
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            }
            else{
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }

        return ans;
    }
}