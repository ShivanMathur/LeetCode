class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        /* Brute Force Solution 
        TC: O(N*(min-max+1))
        
        if(m*k > bloomDay.length){
            return -1;
        }

        int min = bloomDay[0], max = bloomDay[0];
        // Finding min and max in the bloomDay array:
        for(int i=1; i<bloomDay.length; i++){
            if(bloomDay[i] > max){
                max = bloomDay[i];
            }
            else if(bloomDay[i] < min){
                min = bloomDay[i];
            }
        }

        for(int i=min; i<=max; i++){
            if(bouquetPossibility(bloomDay, i, m, k)){
                return i;
            }
        }
        return -1; */

        /* Binary Search Approach */
        if((long)m*(long)k > (long)bloomDay.length){
            return -1;
        }

        int min = bloomDay[0], max = bloomDay[0];
        // Finding min and max in the bloomDay array:
        for(int i=1; i<bloomDay.length; i++){
            if(bloomDay[i] > max){
                max = bloomDay[i];
            }
            else if(bloomDay[i] < min){
                min = bloomDay[i];
            }
        }
        int low = min, high = max;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(bouquetPossibility(bloomDay, mid, m, k)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }

    static boolean bouquetPossibility(int[] bloomDay, int day, int m, int k){
        int count = 0, numBouquets = 0;
        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i] <= day){
                count++;
            }
            else{
                numBouquets += count/k;
                count = 0;
            }
        }
        numBouquets += count/k;
        return numBouquets >= m;
    }
}