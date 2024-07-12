class Solution {
    public int searchInsert(int[] nums, int target) {
        
        return binary_search(nums, 0, nums.length-1, target);
    }

    public int binary_search(int[] nums, int start, int end, int target)
    {
        int mid = (start + end) / 2;
        while(start <= end){
            if(nums[mid] == target){
                return mid;
            }
            if(target > nums[mid]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
            mid = (start + end) / 2;
        }
        if (target > nums[mid])
        return mid+1;
        else
        return mid;

    }
}