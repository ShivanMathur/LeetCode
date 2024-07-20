class Solution {
    public void moveZeroes(int[] nums) {
        int left_ptr = 0;

        for(int right_ptr = 0; right_ptr < nums.length; right_ptr++){
            if(nums[right_ptr] != 0){
                int temp = nums[left_ptr];
                nums[left_ptr] = nums[right_ptr];
                nums[right_ptr] = temp;
                left_ptr++;
            }
        }
    }
}