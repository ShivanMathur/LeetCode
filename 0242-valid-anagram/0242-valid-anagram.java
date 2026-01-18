class Solution {
    public boolean isAnagram(String s, String t) {

        /* Approach 3: Hash Table using Array
            TC: O(n + m)
            SC: O(n)
        */

        if(s.length() != t.length()){
            return false;
        }

        int[] charFreq = new int[26];

        for(int i=0; i<s.length(); i++){
            charFreq[s.charAt(i) - 'a']++;
            charFreq[t.charAt(i) - 'a']--;
        }

        for(int i=0; i<charFreq.length; i++){
            if(charFreq[i] != 0){
                return false;
            }
        }

        return true;

        
        /* Approach 2: Using HashMap
            TC: O(n + m)
            SC: O(n)


        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }

        for(char ch : map.keySet()){
            if(map.get(ch) != 0){
                return false;
            }
        }

        return true;
        */


        /* Approach 1: Sorting both the Strings and Compare sorted arrays
            TC: O(nlogn + mlogm)
            SC: O(1) {Worst case if arrays are of different size} OR O(n){Array element comparison}
        
        
        if(s.length() != t.length()){
            return false;
        }

        char[] sSorted = s.toCharArray();
        char[] tSorted = t.toCharArray();

        Arrays.sort(sSorted);
        Arrays.sort(tSorted);

        return Arrays.equals(sSorted, tSorted);
        
        */
    }
}