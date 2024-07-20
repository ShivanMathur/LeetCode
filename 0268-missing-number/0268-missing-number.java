class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;

        int sum = 0;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        } 

        return len*(len+1)/2 - sum;        
    }
}