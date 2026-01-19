class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board.length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j]=='.') continue;
                if(check1(i,j,board)==false){
                    return false;
                }
            }
        }
        for(int i=0;i<n;i=i+3){
            for(int j=0;j<m;j=j+3){
                if(check2(i,j,board)==false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean check1(int row, int col,char[][] board){
        char check = board[row][col];
        for(int i = 0;i<9;i++){
            if(i==col) continue;
            if(board[row][i]==check) return false;
        }
        for(int i = 0;i<9;i++){
            if(i==row) continue;
            if(board[i][col]==check) return false;
        }
        return true;
    }
    public boolean check2(int row,int col,char[][] board){
        HashSet<Character> set = new HashSet<>();
        for(int i = row;i<row+3;i++){
            for(int j =col;j<col+3;j++){
                char ch = board[i][j];
                if(board[i][j]=='.') continue;
                if(set.contains(ch)){
                    return false;
                }
                set.add(ch);
            }
        }
        return true;
    }
}