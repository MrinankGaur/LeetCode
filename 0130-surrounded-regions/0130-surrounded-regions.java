class Solution {
    public static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public char[][] board;
    public int ROW;
    public int COL;
    public void solve(char[][] board) {
        this.board = board;
        ROW = board.length;
        COL = board[0].length;
        for(int i =0;i<ROW;i++){
            if(board[i][0]=='O') dfs(board,i,0);
            if(board[i][COL-1]=='O') dfs(board,i,COL-1); 
        }
        for(int i =0;i<COL;i++){
            if(board[0][i]=='O') dfs(board,0,i);
            if(board[ROW-1][i]=='O') dfs(board,ROW-1,i);
        }
        for(int i =0;i<ROW;i++){
            for(int j=0;j<COL;j++){
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='#') board[i][j]='O';
            }
        }
        return;
    }
    public void dfs(char[][] board,int row, int col){
        board[row][col]='#';
        for(int[] dir:directions){
            int dr = row + dir[0];
            int dc = col + dir[1];
            if(dr<0 || dc<0 || dr>=ROW || dc>=COL || board[dr][dc]!='O') continue;
            dfs(board,dr,dc);
        }
        return;
    }
}
