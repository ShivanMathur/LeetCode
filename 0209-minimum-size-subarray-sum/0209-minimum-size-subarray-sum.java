class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        // SLIDING WINDWO APPROACH - Dynamic Variant of window
        int minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        int sum = 0;

        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++)
        {
            sum += nums[windowEnd];
            while(sum >= target){
                minLength = Math.min(minLength, (windowEnd - windowStart) + 1);
                sum -= nums[windowStart];
                windowStart++;
            }
        }
        if (!(minLength < Integer.MAX_VALUE))
        return 0;
        
        return minLength;
    }
}