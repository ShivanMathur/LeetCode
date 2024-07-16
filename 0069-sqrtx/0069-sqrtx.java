class Solution {
    public int mySqrt(int x) {
        /* Brute Force Solution */
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
    }
}