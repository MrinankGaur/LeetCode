class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] arr = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<Pair> q = new LinkedList<>();
        int countFresh = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j));
                }
                else if(grid[i][j]==1){
                    countFresh++;
                }
            }
        }
        if(countFresh==0) return 0;
        int cnt = 0;
        int countMin = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int l = 0;l<size;l++){
                Pair curr = q.poll();
                int i = curr.x;
                int j = curr.y;
                for(int[] dir:arr){
                    int x = i+dir[0];
                    int y = j+dir[1];
                    if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==1){
                        grid[x][y] = 2;
                        q.offer(new Pair(x,y));
                        cnt++;
                    }
                }
            }
            if(q.size()!=0){
                countMin++;
            }
        }
        return countFresh == cnt ? countMin: -1;
    }
    public class Pair{
        int x, y;
        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}