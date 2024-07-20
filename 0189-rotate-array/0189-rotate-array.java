class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        rotation(nums, 0, nums.length - 1);
        rotation(nums, 0, k - 1);
        rotation(nums, k, nums.length-1);
        
    }

    public void rotation(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}