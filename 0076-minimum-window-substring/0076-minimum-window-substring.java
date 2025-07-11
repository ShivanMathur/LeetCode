class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(m > n){
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<m; i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        int left = 0, right = 0;
        int charCount = 0;
        int windowSize = Integer.MAX_VALUE;
        int startIndex = -1;

        while(right < n){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                if(map.get(ch) > 0){
                    charCount++;
                }
                map.put(ch, map.get(ch) - 1);

                while(charCount == m){
                    if(right - left + 1 < windowSize){
                        windowSize = right - left + 1;
                        startIndex = left;
                    }
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if(map.get(s.charAt(left)) > 0){
                        charCount--;
                    }
                    left++;
                }
            }
            else{
                map.put(ch, -1);
            }
            right++;
        }

        System.out.println(startIndex + " " + windowSize);

        return startIndex >= 0 ? s.substring(startIndex, startIndex + windowSize) : "";

    }
}