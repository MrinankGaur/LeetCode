class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] arr = {{1,0},{-1,0},{0,1},{0,-1}};
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int[] x:dist) Arrays.fill(x,Integer.MAX_VALUE);
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y)->Integer.compare(x.effort,y.effort));
        pq.offer(new Tuple(0,0,0));
        dist[0][0] = 0;
        while(!pq.isEmpty()){
            Tuple curr = pq.poll();
            int i = curr.i;
            int j = curr.j;
            int effort = curr.effort;
            if(i==n-1 && j==m-1){
                return effort;
            }
            for(int[] dir: arr){
                int di = i+dir[0];
                int dj = j+dir[1];
                if(!isValid(di,dj,n,m)){
                    continue;
                }
                int eff = Math.max(Math.abs(heights[i][j]-heights[di][dj]),effort);
                if(eff<dist[di][dj]){
                    dist[di][dj] = eff;
                    pq.offer(new Tuple(di,dj,eff));
                }
            }

        }
        return 0;
    }
    public boolean isValid(int i,int j,int n, int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
    
}

class Tuple{
    int i,j,effort;
    public Tuple(int i,int j,int effort){
        this.i = i;
        this.j = j;
        this.effort = effort;
    }
}