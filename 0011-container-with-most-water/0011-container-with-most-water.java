class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int result = 0;

        while(left < right){
            int width = right - left;
            int currArea = Math.min(height[left], height[right]) * width;

            result = Math.max(result, currArea);

            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }

        return result;
    }
}