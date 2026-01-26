class Solution {
    public int lengthOfLongestSubstring(String s) {
        /* 2. Sliding Window (Optimized)
            TC: O(N)
            SC: O(M) ; M: Total number of unique characters in the string 
        */

        int maxLength = 0;
        int left = 0, right = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while(right < s.length()){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
        
        /* 1. Sliding Window
            TC: O(N)
            SC: O(M) ; M: Total number of unique characters in the string 

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
        */
    }
}