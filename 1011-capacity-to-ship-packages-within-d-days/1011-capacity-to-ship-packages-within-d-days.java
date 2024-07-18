class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE, high = 0;
        // Find the capacity range
        for(int i=0; i<weights.length; i++){
            if(weights[i] > low){
                low = weights[i];
            }
            high += weights[i];
        }

        while(low <= high){
            int mid = low + (high-low)/2;
            if(daysRequired(weights, mid, days)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return low;
    }

    static boolean daysRequired(int[] weights, int capacity, int days){
        int dayCount = 1, load = 0;
        for(int i=0; i<weights.length; i++){
            if(load + weights[i] > capacity){
                dayCount += 1;
                load = weights[i];
            }
            else{
                load += weights[i];
            }
        }

        return dayCount <= days;
    }
}