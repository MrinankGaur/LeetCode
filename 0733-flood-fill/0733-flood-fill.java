class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color) return image;
        int n = image.length;
        int m = image[0].length;
        int[][] arr = {{-1,0},{1,0},{0,-1},{0,1}};
        image[sr][sc] = color;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr,sc));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.x;
            int c = curr.y;
            for(int[] dir:arr){
                int x = r + dir[0];
                int y = c + dir[1];
                if(x>=0 && y>=0 && x<n && y<m && image[x][y]==originalColor){
                    q.offer(new Pair(x,y));
                    image[x][y] = color;
                }
            }
            image[r][c] = color;
        }
        return image;
    }
    class Pair{
        int x,y;
        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}