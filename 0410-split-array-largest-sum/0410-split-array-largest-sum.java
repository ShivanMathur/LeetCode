class Solution {
    public int splitArray(int[] nums, int k) {
        if(nums.length < k){
            return -1;
        }

        int low = nums[0], high = 0;
        for(int i=0; i<nums.length; i++){
            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        while(low <= high){
            int mid = low + (high - low)/2;

            if(findSum(nums, mid, k)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return low;
    }

    static boolean findSum(int[] nums, int split, int k) {
        int arrSize = 1, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > split) {
                arrSize++;
                sum = nums[i];
            }
        }
        return (arrSize <= k);
    }
}