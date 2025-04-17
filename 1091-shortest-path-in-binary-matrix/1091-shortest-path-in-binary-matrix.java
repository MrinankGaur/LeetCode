class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        if(grid==null || row == 0 || col ==0 || grid[0][0]==1 || grid[row-1][col-1]==1) return -1;
        int ans = 0;

        int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        boolean[][] visited = new boolean[row][col];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0]= true;

        while(!q.isEmpty()){
            int size = q.size();
            ans++;
            for(int i = 0;i<size;i++){
                int[] currPos = q.poll();
                if(currPos[0]==row-1 && currPos[1]==col-1){
                    return ans;
                }
                for(int[] dir: dirs){
                    int nx = currPos[0] + dir[0];
                    int ny = currPos[1] + dir[1];
                    if(nx<0 || ny<0 || nx>=row || ny >= col || visited[nx][ny] || grid[nx][ny]==1){
                        continue;
                    }
                    visited[nx][ny]= true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        return -1;
    
    }
}