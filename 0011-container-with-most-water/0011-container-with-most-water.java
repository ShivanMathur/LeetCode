class Solution {
    public int maxArea(int[] height) {
        /* Approach 1: Two Pointer Approach
            TC: O(n)
            SC: O(1)
        */

        int left = 0, right = height.length - 1;

        int maxVol = 0;

        while(left <= right){
            int ht = Math.min(height[left], height[right]);
            int width = right - left;
            int vol = ht * width;
            maxVol = Math.max(maxVol, vol);

            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }

        return maxVol;
    }
}