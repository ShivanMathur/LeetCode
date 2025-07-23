class Solution {
    public String reorganizeString(String s) {
        // Store count of each character in the string
        int[] hash = new int[26];

        int maxCharCount = 0, letter = 0;

        for(int i=0; i<s.length(); i++){
            hash[s.charAt(i) - 'a']++;
            if(hash[s.charAt(i) - 'a'] > maxCharCount){
                maxCharCount = hash[s.charAt(i) - 'a'];
                letter = (int)(s.charAt(i) - 'a');
            }
        }

        if(maxCharCount > (s.length()+1)/2){
            return "";
        }

        int index = 0;
        char[] result = new char[s.length()];

        while(hash[letter]-- > 0){
            result[index] = (char)(letter + 'a');
            index += 2;
        }

        for(int i=0; i<hash.length; i++){
            while(hash[i]-- > 0){
                if(index >= result.length){
                    index = 1;
                }
                result[index] = (char)(i + 'a');
                index += 2;
            }
        }

        return String.valueOf(result);
    }
}