class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        for(int row = 0;row<n;row++){
            for(int col = 0;col<n;col++){
                if(grid[row][col]==0)continue;
                int[] dx = {0,0,1,-1};
                int[] dy = {1,-1,0,0};
                for(int i = 0;i<4;i++){
                    int nrow = row+dx[i];
                    int ncol = col+dy[i];
                    if(nrow>=0 && ncol>=0 && nrow<n && ncol<n && grid[nrow][ncol]==1){
                        int nodeNo = row*n + col;
                        int adjNodeNo = nrow*n + ncol;
                        ds.unionBySize(nodeNo,adjNodeNo);
                    }
                }
            }
        }
        int mx = 0;
        for(int row = 0;row<n;row++){
            for(int col = 0;col<n;col++){
                if(grid[row][col]==1)continue;
                int[] dx = {0,0,1,-1};
                int[] dy = {1,-1,0,0};
                HashSet<Integer> components = new HashSet<>();
                for(int i = 0;i<4;i++){
                    int nrow = row+dx[i];
                    int ncol = col+dy[i];
                    
                    if(nrow>=0 && ncol>=0 && nrow<n && ncol<n && grid[nrow][ncol]==1){
                        components.add(ds.findParent(nrow*n + ncol));
                    }
                }
                int sizeTotal = 1;
                for(Integer it:components){
                    sizeTotal+=ds.size.get(it);
                }
                mx = Math.max(mx,sizeTotal);
            }
        }
        if(mx==0){
            for(int i = 0;i<n*n;i++){
                mx = Math.max(mx,ds.size.get(ds.findParent(i)));
            }
        }
        return mx;
    }
}
class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for(int i =0;i<n;i++){
            size.add(1);
            parent.add(i);
        }
    }

    public int findParent(int node){
        if(parent.get(node)==node){
            return node;
        }
        int ulp = findParent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }

    public void unionBySize(int n1,int n2){
        int ulp_u = findParent(n1);
        int ulp_v = findParent(n2);
        if(ulp_u==ulp_v)return;
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
        }
        else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_v)+size.get(ulp_u));
        }
    } 
}