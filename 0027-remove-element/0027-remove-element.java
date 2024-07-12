class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        int counter = 0;

        while(i<=j)
        {
            if(nums[i] != val){
                counter++;
            }
            else if(nums[i] == val)
            {
                while(j>i){
                    boolean flag = false;
                    while(nums[j]!=val)
                    {
                        counter++;
                        nums[i] = nums[j];
                        nums[j] = val;
                        flag = true;
                    }
                    j--;
                    if(flag)
                        break;
                }
            }
            i++;
        }
        return counter;
    }
}