class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        for(int i = 0;i<m;i++){
            if(grid[0][i]==1){
                dfs(0,i,n,m,grid,vis);
            }
            if(grid[n-1][i]==1){
                dfs(n-1,i,n,m,grid,vis);
            }
        }
        for(int i = 0;i<n;i++){
            if(grid[i][0]==1){
                dfs(i,0,n,m,grid,vis);
            }
            if(grid[i][m-1]==1){
                dfs(i,m-1,n,m,grid,vis);
            }
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j =0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    count++;
                }
            }
        }

        return count;
    }
    public void dfs(int row, int col,int n,int m, int[][] grid, int[][] vis){
        if(vis[row][col]==1) return;
        vis[row][col]=1;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i =0;i<4;i++){
            int x = dir[i][0];
            int y = dir[i][1];
            int dx = row+x;
            int dy = col+y;
            if(dx>=0 && dy>=0 && dx<n && dy<m && vis[dx][dy]==0 && grid[dx][dy]==1){
                dfs(dx,dy,n,m,grid,vis);
            }
        }

    }
}