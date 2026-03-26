class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int count = 0;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j]=='1'){
                    bfs(grid,dir,row,col,i,j);
                    count++;
                }
            }
        }
        return count;
        
    }
    public void bfs(char[][] grid, int[][] dir, int row, int col,int i,int j){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        grid[i][j]='0';
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int k =0;k<4;k++){
                int dr = r + dir[k][0];
                int dc = c + dir[k][1];
                if(isValid(dr,dc,row,col) && grid[dr][dc]=='1'){
                    q.offer(new int[]{dr,dc});
                    grid[dr][dc]='0';
                }
            }
        }

    }
    public boolean isValid(int dr, int dc, int row, int col){
        if(dr>=0 && dc>=0 && dr<row && dc<col) return true;
        return false;
    }

}
