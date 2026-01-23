class Solution {
    public int compress(char[] chars) {
        /* 
            TC: O(n)
            SC: O(1)
        */

        int index = 0;
        int i = 0;

        while(i < chars.length){
            char currChar = chars[i];
            int currCharCount = 0;

            while(i < chars.length && chars[i] == currChar){
                currCharCount++;
                i++;
            }
            chars[index++] = currChar;
            if(currCharCount > 1){
                for(char ch : Integer.toString(currCharCount).toCharArray()){
                    chars[index++] = ch;
                }
            }
        }

        return index;
    }
}