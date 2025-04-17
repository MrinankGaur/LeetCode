class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int[][] dist = new int[row][col];
        for(int[] x : dist){
            Arrays.fill(x,Integer.MAX_VALUE);
        }
        dist[0][0]= 0;
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x,y)->x.effort-y.effort);
        pq.add(new Tuple(0,0,0));
        while(pq.size()!=0){
            Tuple curr = pq.poll();
            int dis = curr.effort;
            int x = curr.r;
            int y = curr.c;
            if(x==row-1 && y == col-1){
                    return dis;
            }
            for(int i = 0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || ny<0 || nx>=row || ny >= col){
                    continue;
                }
                int eff =  Math.max(Math.abs(heights[x][y]-heights[nx][ny]),dis);
                if(eff<dist[nx][ny]){
                    dist[nx][ny]=eff;
                    pq.add(new Tuple(eff,nx,ny));
                }
            }

        }
        
        return 0;
    }

    class Tuple{
        int effort,r,c;

        public Tuple(int effort,int r,int c){
            this.effort = effort;
            this.r = r;
            this.c = c;
        }
    }
}