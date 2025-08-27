class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] arr = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,1},{1,0}};
        int n = grid.length;
        if(grid[0][0]!=0 || grid[n-1][n-1]!=0) return -1;
        PriorityQueue<Tuple> q = new PriorityQueue<>((x,y)->Integer.compare(x.effort,y.effort));
        q.offer(new Tuple(0,0,1));
        grid[0][0] = 1;
        while(!q.isEmpty()){
            Tuple curr = q.poll();
            int i = curr.i;
            int j = curr.j;
            int effort = curr.effort;
            if(i==n-1 && j==n-1){
                return effort;
            }
            for(int[] dir: arr){
                int di = i+dir[0];
                int dj = j+dir[1];
                
                if( isValid(di,dj,n) && grid[di][dj]==0){
                    q.offer(new Tuple(di,dj,effort+1));
                    grid[di][dj] = 1;
                }
            }

        }
        return -1;
    }
    public boolean isValid(int i,int j,int n){
        return i>=0 && j>=0 && i<n && j<n;
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