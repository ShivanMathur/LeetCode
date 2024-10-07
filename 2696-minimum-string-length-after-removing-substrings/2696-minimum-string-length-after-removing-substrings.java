class Solution {
    public int minLength(String s) {
        int write = 0, read = 0;

        char[] arr = s.toCharArray();

        while(read < s.length()){
            arr[write] = s.charAt(read);

            if(write > 0 && (arr[write-1]=='A' || arr[write-1]=='C') && (arr[write]-'A') == (arr[write-1]-'A'+1)){
                write--;
            }
            else{
                write++;
            }
            read++;
        }

        return write;        
    }
}