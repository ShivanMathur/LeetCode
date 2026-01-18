class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        /* Approach 1: Using HashMap
            TC: O(m * nlogn)
            SC : O(m * n)
        */

        HashMap<String, List<String>> map = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            String str = strs[i];
            char[] str_to_array = str.toCharArray();
            Arrays.sort(str_to_array);
            String strSorted = new String(str_to_array);

            if(!map.containsKey(strSorted)){
                map.put(strSorted, new ArrayList<>());
            }
            map.get(strSorted).add(str);
        }

        return new ArrayList<>(map.values());
    }
}