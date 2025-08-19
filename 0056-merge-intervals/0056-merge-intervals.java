import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> list = new ArrayList<>();
        int[] current = intervals[0];  // Start with the first interval
        list.add(current);

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (next[0] <= current[1]) {
                // Overlapping → merge
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap → push new interval
                current = next;
                list.add(current);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
