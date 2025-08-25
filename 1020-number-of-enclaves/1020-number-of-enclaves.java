class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] arr = {{0,1},{0,-1},{1,0},{-1,0}};
        int[][] vis = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1){
                        dfs(i,j,n,m,arr,vis,grid);
                    }
                }
            }
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;

    }
    public void dfs(int i,int j,int n,int m,int[][] arr,int[][] vis,int[][] board){
        vis[i][j] = 1;
        for(int[] dir:arr){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x>=0 && y>=0 && x<n && y<m && board[x][y]==1 && vis[x][y]==0){
                dfs(x,y,n,m,arr,vis,board);
            }
        }
    }
}