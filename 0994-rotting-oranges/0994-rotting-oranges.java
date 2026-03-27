class Solution {
    public int orangesRotting(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0;i<ROW;i++){
            for(int j = 0;j<COL;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int minute = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean rot = false;
            for(int k = 0;k<size;k++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for(int[] dir:directions){
                    int dr = r + dir[0];
                    int dc = c + dir[1];
                    if(dr<0 || dc<0 || dr>=ROW || dc>=COL || grid[dr][dc]!=1) continue;
                    q.offer(new int[]{dr,dc});
                    grid[dr][dc]=2;
                    fresh--;
                    if(fresh==0) return minute+1;
                    rot = true;
                }
            }
            minute = (rot)?minute+1:minute;
        }
        
        return (fresh==0)?minute:-1;   
    }
}
