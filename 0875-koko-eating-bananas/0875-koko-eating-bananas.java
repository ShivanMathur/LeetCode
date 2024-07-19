class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = findMax(piles);

        while(low <= high){
            int mid = low + (high-low)/2;
            if(eatingTime(piles, mid, h)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return low;

    }

    static int findMax(int[] piles){
        int max = piles[0];
        for(int i=1; i<piles.length; i++){
            if(piles[i]>max){
                max = piles[i];
            }
        }
        return max;
    }
    static boolean eatingTime(int[] piles, int num, int h){
        int time = 0;
        for(int i=0; i<piles.length; i++){
            time += Math.ceil((double)piles[i]/(double)num);
        }

        return time <= h;
    }
}