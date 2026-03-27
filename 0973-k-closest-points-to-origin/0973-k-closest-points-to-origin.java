class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> cmp = (a, b) -> {
            int dist1 = a[0]*a[0] + a[1]*a[1];
            int dist2 = b[0]*b[0] + b[1]*b[1];
            return Integer.compare(dist1, dist2);
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);
        for(int[] point:points){
            pq.offer(point);
        }
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
}
