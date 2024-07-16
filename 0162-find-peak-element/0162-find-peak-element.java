class Solution {
    public int findPeakElement(int[] nums) {
        /*int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2]) {
                low = mid2;
            } else {
                high = mid1;
            }
        }

        return low;
        */

        /* TUF Approach */
        if(nums.length <= 1){
            return 0;
        }
        if(nums[0] > nums[1]){
            return 0;
        }
        if(nums[nums.length-1] > nums[nums.length-2]){
            return nums.length-1;
        }
        int low = 1, high = nums.length-2;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] > nums[mid-1] && nums[mid]> nums[mid+1]){
                return mid;
            }
            if(nums[mid] < nums[mid+1]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}