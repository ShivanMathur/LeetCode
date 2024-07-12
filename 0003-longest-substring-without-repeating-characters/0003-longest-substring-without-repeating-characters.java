class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, maxLength = 0;
        Map<Character, Integer> count = new HashMap<>();

        for(int right = 0; right<s.length(); right++){
            char c = s.charAt(right);
            if(count.containsKey(c)){
                left = Math.max(left, count.get(c));
            }
            maxLength = Math.max(maxLength, (right - left) + 1);
            count.put(c, right + 1);
        }
        return maxLength;
    }
}