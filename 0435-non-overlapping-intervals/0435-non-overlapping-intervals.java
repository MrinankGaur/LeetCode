class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> (a[1]-b[1]));
        int endTime = Integer.MIN_VALUE;
        int overlapping = 0;
        for(int[] interval : intervals){
            int newEnd = interval[0];
            if(newEnd < endTime){
                overlapping++;
            }else{
                endTime = interval[1];
            }
        }
        return overlapping;
    }
}