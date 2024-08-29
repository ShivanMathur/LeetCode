class Solution {
    public int lengthOfLastWord(String s) {
        int endIndex = s.length()-1;

        int length = 0;

        for(int index = s.length()-1; index>=0; index--){
            if(s.charAt(index) != ' '){
                length++;
            }
            else{
                if(length > 0){
                    return length;
                }
            }
        }

        return length;
    }
}