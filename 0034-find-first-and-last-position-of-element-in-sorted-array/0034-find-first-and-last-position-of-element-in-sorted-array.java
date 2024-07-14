class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirstPosition(nums, target);
        if(first == -1){
            return new int[]{-1, -1};
        }
        int last = findLastPosition(nums, target);
        return new int[]{first, last};
    }

    static int findFirstPosition(int[] nums, int target){
        int first = -1;
        int low = 0, high = nums.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                first = mid;
                high = mid-1;
            }
            else if(nums[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return first;
    }

    static int findLastPosition(int[] nums, int target){
        int last = -1;
        int low = 0, high = nums.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                last = mid;
                low = mid+1;
            }
            else if(nums[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return last;
    }
}