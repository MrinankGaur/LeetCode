class Solution {
    static char[][] global;
    public int numIslands(char[][] grid) {
        int res = 0;
        global = grid;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 'x' || grid[i][j] == '0'){
                    continue;
                }
                else{
                    res++;
                    findOne(i,j);
                }
            }
        }
        return res;
    }

    public void findOne(int row, int col){
        global[row][col] = 'x';
        if(row < global.length - 1){
            //move bot
            if(global[row + 1][col] != 'x' && global[row + 1][col] != '0'){
                findOne(row + 1,col);
            }
        }
        if(row > 0){
            //move top
            if(global[row - 1][col] != 'x' && global[row - 1][col] != '0'){
                findOne(row - 1,col);
            }
        }
        if(col < global[0].length - 1){
            //move right
            if(global[row][col + 1] != 'x' && global[row][col + 1] != '0'){
                findOne(row,col + 1);
            }
        }
        if(col > 0){
            //move left
            if(global[row][col - 1] != 'x' && global[row][col - 1] != '0'){
                findOne(row,col - 1);
            }
        }
    }
}
