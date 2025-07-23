class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for(int i=0; i<intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int countRooms = 0;
        int result = 0;
        int s_ptr = 0, e_ptr = 0;

        while(s_ptr < intervals.length){
            if(start[s_ptr] < end[e_ptr]){
                countRooms++;
                s_ptr++;
            }
            else{
                countRooms--;
                e_ptr++;
            }
            result = Math.max(result, countRooms);
        }

        return result;
    }
}