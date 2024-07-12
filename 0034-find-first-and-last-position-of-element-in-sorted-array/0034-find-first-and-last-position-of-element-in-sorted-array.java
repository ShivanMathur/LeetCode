class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];

        if(nums == null){
            return ans;
        }

        int low = 0, high = nums.length-1;
        int idx0 = -1, idx1 = -1;

        while(low <= high){
            int mid = low + (high-low) / 2;
            if (nums[mid] >= target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
            if(nums[mid] == target){
                idx0 = mid;
            }
        }

        low = 0; 
        high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low) / 2;
            if (nums[mid] <= target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
            if(nums[mid] == target){
                idx1 = mid;
            }
        }

        ans[0] = idx0;
        ans[1] = idx1;

        return ans;
    }
}