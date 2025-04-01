class Solution {
    public int numEnclaves(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        int[][] vis = new int[row][col];
        for(int i = 0 ;i<row;i++){
            for(int j = 0 ;j<col;j++){
                if(i==0 || j==0 || i == row-1 || j== col-1){
                    if(grid[i][j]==1){
                        q.offer(new int[]{i,j});
                        vis[i][j]=1;
                    }
                }
            }
        }
        int[] drow = {0,0,-1,1};
        int[] dcol = {1,-1,0,0};
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            q.remove();
            for(int i =0;i<4;i++){
                int nr = r + drow[i];
                int nc = c + dcol[i];
                if(nr>=0 && nc>=0 && nr<row-1 && nc<col-1 && vis[nr][nc]==0 && grid[nr][nc]==1){
                    q.offer(new int[]{nr,nc});
                    vis[nr][nc]=1;
                }
            }
        }
        int count  = 0;
        for(int i = 0 ;i<row;i++){
            for(int j = 0 ;j<col;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                   count++;
                }
            }
        }
        return count;
    }
}