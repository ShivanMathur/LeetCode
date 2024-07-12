class Solution {
    public int reverse(int x) {
        long reverseNum = 0;
        while(x != 0){
            reverseNum = reverseNum*10 + x%10;
            x /= 10;
        }
        return reverseNum>Integer.MAX_VALUE || reverseNum<Integer.MIN_VALUE ? 0 : (int)reverseNum;
    }
}