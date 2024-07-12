class Solution {
    public void sortColors(int[] nums) {
        int ptr_0 = 0, ptr_2 = nums.length - 1, itr = 0;

        while(itr <= ptr_2){
            if(nums[itr] == 0){
                nums[itr] = nums[ptr_0];
                nums[ptr_0] = 0;
                ptr_0++;
                
            }
            if(nums[itr] == 2){
                nums[itr] = nums[ptr_2];
                nums[ptr_2] = 2;
                ptr_2--;
                itr--;
            }
            itr++;
        }
    }
}