class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /* Approach 1: Consider the thirst element as -(first + second). Then find if the third exists in the HashSet. If not, store the second element in the set and move ot the right. 
        TC: O(N^2 * log(no. of unique triplets))
        SC: O(2 * no. of the unique triplets) + O(N)

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
        */

        /* Optimal Approach: First Sort the array and apply the Two pointer approach */

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int first=0; first<nums.length; first++){
            if(first>0 && nums[first] == nums[first - 1]){
                continue;
            }

            int second = first + 1;
            int third = nums.length - 1;

            while(second < third){
                int sum = nums[first] + nums[second] + nums[third];
                if(sum == 0){
                    List<Integer> tempAns = Arrays.asList(nums[first], nums[second], nums[third]);
                    result.add(tempAns);
                    second++;
                    third--;
                    
                    while(second < third && nums[second] == nums[second - 1]){
                        second++;
                    }
                    while(second < third && nums[third] == nums[third + 1]){
                        third--;
                    }
                }
                else if(sum > 0){
                    third--;
                }
                else{
                    second++;
                }
            }
        }

        return result;
    }
}