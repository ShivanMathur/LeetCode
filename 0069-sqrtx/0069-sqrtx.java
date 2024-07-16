class Solution {
    public int mySqrt(int x) {
        /* Brute Force Solution
        if(x==0){
            return 0;
        }
        
        long ans = 1;
        for(long i=1; i<=(long)x; i++){
            if(i*i <= x){
                ans = i;
            }
            else{
                break;
            }
        }

        return (int)ans;
        */

        /* Binary Search Apprach */
        int low = 1, high = x;
        while(low <= high){
            long mid = low + (high - low)/2;
            long mul = mid * mid;
            if(mul <= x){
                low = (int)(mid+1);
            }
            else{
                high = (int)(mid-1);
            }
        } 

        return high;
    }
}