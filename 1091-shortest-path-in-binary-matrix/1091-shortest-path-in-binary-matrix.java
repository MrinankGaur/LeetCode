class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
      int[][] directions={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
      int m=grid.length;
      int n=grid[0].length;
      if(grid[0][0]!=0 || grid[m-1][n-1]!=0)
      {
        return -1;
      }
      Queue<int[]> queue=new LinkedList<>();
      queue.add(new int[]{0,0,1});
      grid[0][0]=1;
      while(!queue.isEmpty())
      {
         int[] current=queue.poll();
         int row=current[0];
         int col=current[1];
         int distance=current[2];
         if(row==m-1 && col==n-1)
         {
            return distance;
         }
         for(int[] direction:directions)
         {
            int newrow=row+direction[0];
            int newcol=col+direction[1];
            if(isValid(m,n,newrow,newcol,grid))
            {
                queue.add(new int[]{newrow,newcol,distance+1});
                grid[newrow][newcol]=1;
            }
         }
      }
      return -1;
    }
    public static boolean isValid(int m,int n,int row,int col,int[][] grid)
    {
        if(row<0 || row>=m || col<0 || col>=n || grid[row][col]==1)
        {
            return false;
        }
        return true;
    }
}