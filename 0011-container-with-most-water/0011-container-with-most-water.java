class Solution {
    public int maxArea(int[] height) {
        int left_ptr = 0, right_ptr = height.length - 1;
        int maxArea = 0;

        while (left_ptr < right_ptr){
            int width = right_ptr - left_ptr;
            int ht = Math.min(height[left_ptr], height[right_ptr]);

            maxArea = Math.max(maxArea, width*ht);

            while(left_ptr < right_ptr && height[left_ptr] <= ht){
                left_ptr++;
            }
            while(left_ptr < right_ptr && height[right_ptr] <= ht){
                right_ptr--;
            }
        }
        System.gc();
        return maxArea;
    }
}