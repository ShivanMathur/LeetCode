class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            int temp = nums[Math.abs(nums[i]) - 1];
            if(temp > 0){
                nums[Math.abs(nums[i]) - 1] *= -1; 
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }
}