class Solution {
    public int lengthOfLongestSubstring(String s) {
        /* Approach 2: Sliding Window + Two Pointer
            TC: O(n)
            SC: O(m); m: Total number of unique characters in the string
        */

        HashSet<Character> set = new HashSet<>();

        int left = 0, right = 0;
        int maxLength = 0;

        while(right < s.length()){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            right++;

            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;

        /* Approach 1: Brute Force - Generate all possible substrings
            TC: O(n^2)
            SC: O(n)
        

        int maxLength = 0;
        for(int i=0; i<s.length(); i++){
            int[] freq = new int[256];
            for(int j=i; j<s.length(); j++){
                if(freq[s.charAt(j)] == 1){
                    break;
                }
                maxLength = Math.max(maxLength, j - i + 1);
                freq[s.charAt(j)] = 1;
            }
        }

        return maxLength;
        */
    }
}