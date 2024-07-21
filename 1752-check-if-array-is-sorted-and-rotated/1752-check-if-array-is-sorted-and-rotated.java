class Solution {
    public boolean check(int[] nums) {
        int counter = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > nums[(i + 1) % nums.length]) {
                counter++;
            }
            i++;
        }
        return counter > 1 ? false : true;
    }
}