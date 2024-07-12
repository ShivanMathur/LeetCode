class Solution {
    public int strStr(String haystack, String needle) {
        /* 
        int hLen = haystack.length(), nLen = needle.length();

        for(int i=0; i<=(len1-len2); i++){
            String temp = haystack.substring(i, i+len2);
            System.out.println(temp);
            if(needle.equals(temp)){
                return i;
            }
        }

        return -1; */

        /* Optimed Code: Sliding Window Approach */
        
        int hLen = haystack.length(), nLen = needle.length();
        int nIndex = 0;

        for(int i=0; i<hLen; i++){
            if(haystack.charAt(i) == needle.charAt(nIndex)){
                nIndex++;
            }
            else{
                i = i - nIndex;
                nIndex = 0;
            }
            if(nIndex == nLen){
                return i-nIndex+1;
            }
        }

        return -1;
    }
}