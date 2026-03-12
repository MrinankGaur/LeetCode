class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            q.poll();
            zeroes(r,c,matrix);
        }
    }
    public void zeroes(int r,int c, int[][] matrix){
        for(int i = 0; i < matrix[0].length; i++){
            matrix[r][i] = 0;
        }

        for(int i = 0; i < matrix.length; i++){
            matrix[i][c] = 0;
        }
    }
}