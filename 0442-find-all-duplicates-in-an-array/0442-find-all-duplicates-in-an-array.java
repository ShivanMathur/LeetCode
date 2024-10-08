class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            int n = Math.abs(nums[i]);

            if(nums[n - 1] < 0){
                result.add(n);
            }
            nums[n - 1] *= -1;
        }

        return result;
    }
}