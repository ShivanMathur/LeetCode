class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /* Approach 1: Consider the thirst element as -(first + second). Then find if the third exists in the HashSet. If not, store the second element in the set and move ot the right. 
        TC: O(N^2 * log(no. of unique triplets))
        SC: O(2 * no. of the unique triplets) + O(N)

        */

        Set<List<Integer>> tripletSet = new HashSet<>();

        for(int first=0; first<nums.length; first++){
            Set<Integer> lookupSet = new HashSet<>();
            for(int second=first+1; second<nums.length; second++){
                int third = -(nums[first] + nums[second]);
                if(lookupSet.contains(third)){
                    List<Integer> tempAns = Arrays.asList(nums[first], nums[second], third);
                    tempAns.sort(null);
                    tripletSet.add(tempAns);
                }
                lookupSet.add(nums[second]);
            }
        }

        List<List<Integer>> result = new ArrayList<>(tripletSet);
        return result;
    }
}