class Solution {
    public int[] sortedSquares(int[] nums) {
        int left_ptr = 0, right_ptr = nums.length-1;
        int result[] = new int[nums.length];
        for(int i=nums.length-1; i>=0; i--){
            if(Math.abs(nums[left_ptr]) > Math.abs(nums[right_ptr])){
                result[i] = nums[left_ptr] * nums[left_ptr];
                left_ptr++;
            }
            else{
                result[i] = nums[right_ptr] * nums[right_ptr];
                right_ptr--;
            }
        }
        return result;
    }
}