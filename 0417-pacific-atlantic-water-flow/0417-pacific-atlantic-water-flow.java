class Solution {
    public static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] heights;
    private int ROW;
    private int COL;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        ROW = heights.length;
        COL = heights[0].length;
        HashSet<String> pacific = new HashSet<>();
        HashSet<String> atlantic = new HashSet<>();
        for(int i =0;i<ROW;i++){
            dfs(pacific,i,0);
            dfs(atlantic,i,COL-1);
        }
        for(int i =0;i<COL;i++){
            dfs(pacific,0,i);
            dfs(atlantic,ROW-1,i);
        }
        List<List<Integer>> list = new ArrayList<>();
        for(String arr:pacific){
            if(atlantic.contains(arr)){
              String[] parts = arr.split(",");
                list.add(Arrays.asList(
                    Integer.parseInt(parts[0]),
                    Integer.parseInt(parts[1])
                ));  
            }
        }
        return list;
    }
    public void dfs(HashSet<String> ocean, int row, int col){
        String str = row + "," + col;
        if(ocean.contains(str)) return;
        ocean.add(str);
        for(int[] dir:directions){
            int dr = row + dir[0];
            int dc = col + dir[1];
            String check = dr+ ","+dc;
            if(dr<0 || dc<0 || dr>=ROW || dc>=COL || heights[dr][dc]<heights[row][col])continue;
            dfs(ocean,dr,dc);
        }
        return;
    }
}
