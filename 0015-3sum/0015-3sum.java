class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        /* TUF :: Better Approach: Using Hashing
        TC: O(N^2 * log(no. of unique triplets))
        SC: O(2 * no. of the unique triplets) + O(N)
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            Set<Integer> hashset = new HashSet<>();

            for(int j=i+1; j<nums.length; j++){
                int third = -(nums[i] + nums[j]);
                if(hashset.contains(third)){
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    temp.sort(null);
                    set.add(temp);
                }
                hashset.add(nums[j]);
            }
        }

        List<List<Integer>> result = new ArrayList<>(set);
        return result; */

        /* TUF: Optimal Approach */
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    result.add(temp);
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1]){
                        j++;
                    }
                    while(j<k && nums[k] == nums[k+1]){
                        k--;
                    }
                }
                else if(sum < 0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }

        return result;
    }
}