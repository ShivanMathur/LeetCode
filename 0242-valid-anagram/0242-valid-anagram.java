class Solution {
    public boolean isAnagram(String s, String t) {
        /* Approach 1: Sorting both the strings and compare
            TC: O(nlogn + mlogm)
            SC: O(1) {Worst case if arrays are of different size} OR O(n){Array element comparison}
        */

        if(s.length() != t.length()){
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }
}