class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int count1 = 0, ele1 = Integer.MIN_VALUE;
        int count2 = 0, ele2 = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            // If count1 is 0 and the current number is not equal to candidate2, update candidate1.
            if(count1 == 0 && nums[i] != ele2){
                count1++;
                ele1 = nums[i];
            }

            // If count2 is 0 and the current number is not equal to candidate1, update candidate2.
            else if(count2 == 0 && nums[i] != ele1){
                count2++;
                ele2 = nums[i];
            }

            // Update counts for candidate1 and candidate2.
            else if(ele1 == nums[i]){
                count1++;
            }
            else if(ele2 == nums[i]){
                count2++;
            }

            // If the current number is different from both candidates, decrement their counts.
            else{
                count1--;
                count2--;
            }
        }

        List<Integer> result = new ArrayList<>();

        // Threshold for majority element
        int threshold = nums.length / 3;
        
        // Second pass to count occurrences of the potential majority elements.
        count1 = 0; 
        count2 = 0;

        for(int i=0; i<nums.length; i++){
            if(ele1 == nums[i]){
                count1++;
            }
            else if(ele2 == nums[i]){
                count2++;
            }
        }

        // Check if the counts of potential majority elements are greater than n/3 and add them to the result.
        if(count1 > threshold){
            result.add(ele1);
        }
        if(count2 > threshold){
            result.add(ele2);
        }
        return result;
    }
}