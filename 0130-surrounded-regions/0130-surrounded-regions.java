class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] arr = {{0,1},{0,-1},{1,0},{-1,0}};
        int[][] vis = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    if(board[i][j]=='O'){
                        dfs(i,j,n,m,arr,vis,board);
                    }
                }
            }
        }
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(vis[i][j]==0 && board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }


    }
    public void dfs(int i,int j,int n,int m,int[][] arr,int[][] vis,char[][] board){
        vis[i][j] = 1;
        for(int[] dir:arr){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x>=0 && y>=0 && x<n && y<m && board[x][y]=='O' && vis[x][y]==0){
                dfs(x,y,n,m,arr,vis,board);
            }
        }
    }
}