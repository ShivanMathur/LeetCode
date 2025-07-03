class Solution {
    public boolean isAnagram(String s, String t) {
        // HashMap Approach
        HashMap<Character, Integer> map = new HashMap<>();
        int s_len = s.length();
        int t_len = t.length();

        if(s_len != t_len){
            return false;
        }

        for(int i=0; i<s_len; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }

        for(char c:map.keySet()){
            if(map.get(c)!=0){
                return false;
            }
        }

        return true;
    }
}