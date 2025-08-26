class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        char start = word.charAt(0);
        boolean ans = false;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j]==start && f(board,word,i,j,n,m,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean f(char[][] board,String word,int i,int j, int n,int m,int count){
        if(count==word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=n || j>=m || board[i][j]!=word.charAt(count)) return false;

        char temp = board[i][j];
        board[i][j]='*';
        boolean ans = f(board,word,i+1,j,n,m,count+1) || f(board,word,i-1,j,n,m,count+1)|| f(board,word,i,j+1,n,m,count+1) || f(board,word,i,j-1,n,m,count+1);
        board[i][j]=temp;
        return ans;
    }
}