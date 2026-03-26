class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] vis = new int[row][col];
        int count=0;
        for(int i =0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    dfs(grid,row,col,i,j,vis);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int r,int c,int i,int j,int[][] vis){
        if(i<0 || j<0 || i>=r || j>=c){
            return;
        }
        if(vis[i][j]==1){
            return;
        }
        if(grid[i][j]=='0'){
            return;
        }
        vis[i][j]=1;
        dfs(grid,r,c,i+1,j,vis);
        dfs(grid,r,c,i-1,j,vis);
        dfs(grid,r,c,i,j+1,vis);
        dfs(grid,r,c,i,j-1,vis);
    }

}
