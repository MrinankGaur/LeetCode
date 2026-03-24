class Solution {
    private class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int row = grid.length;
        int col = grid[0].length;
        int[][] vis = new int[row][col];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j]==1){
                    q.add(new Pair(i,j));
                    vis[i][j]=1;
                    
                }
            }
            if(q.size()>0) break;
        }
        while(!q.isEmpty()){   
            Pair curr = q.poll();
            int r = curr.first;
            int c = curr.second;
            int sides = 0;
            for(int i=0;i<4;i++){
                int dr = r+dx[i];
                int dc = c+dy[i];
                if(isValid(row,col,dr,dc) && grid[dr][dc]==1){
                    sides++;
                    if(vis[dr][dc]==0){
                        q.add(new Pair(dr,dc));
                        vis[dr][dc]=1;
                    }
                }
            }
            perimeter += 4-sides;
        }
        return perimeter;

    }

    public boolean isValid(int r,int c,int i,int j){
        if(i>=0 && j>=0 && i<r && j<c) return true;
        return false;
    }
}