class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int pointer_1 = 0, pointer_2 = numbers.length - 1;

        while(pointer_1 < pointer_2){
            int sum = numbers[pointer_1] + numbers[pointer_2];
            if(sum == target){
                System.gc();
                return new int[]{pointer_1 + 1, pointer_2 + 1};
            }
            else if (sum > target){
                pointer_2 -= 1;
            }
            else{
                pointer_1 += 1;
            }
        }
    return new int[2];
    }
}