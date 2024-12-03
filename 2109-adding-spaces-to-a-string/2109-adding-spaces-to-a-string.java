class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder str = new StringBuilder();

        int ptr = 0, i = 0;

        while(i < s.length() ){
            if(ptr < spaces.length && i == spaces[ptr]){
                str.append(" ");
                ptr++;
            }
            str.append(s.charAt(i));
            i++;
        }

        return str.toString();

    }
}