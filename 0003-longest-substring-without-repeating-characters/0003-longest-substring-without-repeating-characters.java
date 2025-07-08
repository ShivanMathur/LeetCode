class Solution {
    public int lengthOfLongestSubstring(String s) {
        /* Sliding Window
            TC: O(N)
            SC: O(M) ; M: Total number of unique characters in the string 
        */
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();

        int maxLength = 0;

        while(right < s.length()){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}