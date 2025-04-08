class Solution {
    public int minimumOperations(int[] nums) {
        // Sliding Window Approach
        int left = 0, right = 0, n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        int count = 0;

        while(right < n){
            if (set.contains(nums[right])){
                count++;
                if(left+3 < n){
                    left += 3;
                    right = left;
                    set = new HashSet<>();
                }
                else{
                    return count;
                }

            }
            else{
                set.add(nums[right]);
                right++;
            }
        }

        return count;
    }
}