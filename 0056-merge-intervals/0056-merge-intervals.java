class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        int n = intervals.length;
        if(n==1){
            return intervals;
        }
        int i = 0;
        int x = Integer.MAX_VALUE;
        int y = Integer.MIN_VALUE;
        while(i<n-1 && intervals[i][1]<intervals[i+1][0]){
            list.add(intervals[i]);
            i=i+1;
        }
        while(i<n-1 && intervals[i][1]>=intervals[i+1][0]){
            x = Math.min(x,intervals[i][0]);
            y = Math.max(y,intervals[i+1][1]);
            i=i+2;
        }
        if(x!=Integer.MAX_VALUE || y!=Integer.MIN_VALUE)
            list.add(new int[]{x,y});
        while(i<n){
            list.add(intervals[i]);
            i=i+1;
        }
        n = list.size();
        int[][] ans =new int[n][2];
        for(i = 0;i<n;i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}