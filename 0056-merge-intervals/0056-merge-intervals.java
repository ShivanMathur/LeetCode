class Solution {
    public int[][] merge(int[][] intervals) {
        /* Brute Force
            TC: O(nlogn){Sorting} + O(2n){checking every pair twice}
            SC: O(n)
        

        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(!result.isEmpty() && end <= result.get(result.size() - 1)[1]){
                continue;
            }
            for(int j=i+1; j<n; j++){
                if(intervals[j][0] <= end){
                    end = Math.max(end, intervals[j][1]);
                }
                else{
                    break;
                }
            }
            result.add(new int[]{start, end});
        }

        return result.toArray(new int[result.size()][]);
        */

        /*
            Optimized Approach
            TC: O(nlogn) + O(n)
            SC: O(n)
        */
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1; i<n; i++){
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            }
            else{
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}