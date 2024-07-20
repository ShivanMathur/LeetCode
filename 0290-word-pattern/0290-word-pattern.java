class Solution {
    public boolean wordPattern(String pattern, String s) {
        String str[] = s.split(" ");
        if(pattern.length() != str.length){
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        Set<String> words = new HashSet<>();
        boolean ans = true;

        for(int i=0; i<str.length; i++){
            if(!map.containsKey(pattern.charAt(i))){
                if(!words.add(str[i])){
                    return false;
                }
                map.put(pattern.charAt(i), str[i]);
            }
            else if(!map.get(pattern.charAt(i)).equals(str[i])){
                return false;
            }
        }
        return true;
    }
}