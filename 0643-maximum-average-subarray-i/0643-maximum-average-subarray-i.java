class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        // SLIDING WINDOW APPROACH
        double maxAverage = Integer.MIN_VALUE;
        double currentSum = 0;

        for(int i=0; i<nums.length; i++)
        {
            currentSum += nums[i];
            if(i >= (k-1)){
                maxAverage = Math.max(maxAverage, currentSum/k);
                currentSum -= nums[i - (k - 1)];
            }
        }

        return maxAverage;
    }
}