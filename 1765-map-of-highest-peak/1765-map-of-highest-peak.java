class Solution {
    public int[][] highestPeak(int[][] mat) {
        int r = mat.length;
        int c  = mat[0].length;
        int[][] vis = new int[r][c];
        int[][] dist = new int[r][c]; 
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                if(mat[i][j]==1){
                  q.add(new int[]{i,j,0});
                  vis[i][j]=1; 
                }else{
                    vis[i][j]=0;
                }
            }
        }
        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, +1, 0, -1};
        while(!q.isEmpty()){
            int row = q.peek()[0];
            int col = q.peek()[1];
            int d = q.peek()[2];
            //System.out.println("row :"+row+" col: "+col+" d: "+d);
            q.remove();
            dist[row][col]=d;
            
            for(int i = 0;i<4;i++){
                int nr = row + drow[i];
                int nc = col + dcol[i];
                if(nr>=0 && nr<r && nc>=0 && nc<c && vis[nr][nc]==0 ){
                    vis[nr][nc]=1;
                    q.add(new int[]{nr,nc,d+1});
                }
            }
        }
        return dist;
    }
}