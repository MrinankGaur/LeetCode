// BFS SOLUTION
// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         int row = image.length;
//         int col = image[0].length;
        
//         Queue<int[]> q = new LinkedList<>();
//          q.offer(new int[]{sr,sc});

//         int[] drow = {0,0,1,-1};
//         int[] dcol = {1,-1,0,0};
//         int[][] vis= new int[row][col];
//         while(!q.isEmpty()){
//             int r = q.peek()[0];
//             int c = q.peek()[1];
//             int check = image[r][c];
//             vis[r][c]=1;
//             image[r][c]=color;
//             q.remove();
//             for(int i = 0;i<4;i++){
//                 int nr = r + drow[i];
//                 int nc = c + dcol[i];
//                 if(nr>=0 && nc>=0 && nr<row && nc<col && vis[nr][nc]!=1 && check==image[nr][nc]){
//                     q.offer(new int[]{nr,nc});
//                 }
//             }
//         }
//         return image;
        
           
//     }
// }

// DFS SOLUTION

class Solution {
    static int newColor=0;
    static int originalColor=0;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        newColor=color;
        originalColor=image[sr][sc];
        dfs(image, sr,sc);
        return image;
    }
    void dfs(int[][] image, int sr, int sc){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc]!=originalColor || image[sr][sc]==newColor ){
            return;
        }
         image[sr][sc] = newColor;
    dfs(image, sr + 1, sc);
    dfs(image, sr - 1, sc);
    dfs(image, sr, sc + 1);
    dfs(image, sr, sc - 1);
    }
}