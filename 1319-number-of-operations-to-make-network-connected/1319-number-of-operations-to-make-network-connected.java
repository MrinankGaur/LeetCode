class Solution {
    public int makeConnected(int n, int[][] connections) {
        if((connections.length)<n-1){
            return -1;
        }
        DisjointSet ds = new DisjointSet(n);
        int extraEdges=0;
        int nc = 0;
        for(int[] arr: connections){
            int u = arr[0];
            int v = arr[1];
            if(ds.findUParent(u)!=ds.findUParent(v)){
                ds.unionBySize(u,v);
            }
            else{
                extraEdges++;
            }
        }
         Set<Integer> uniqueParents = new HashSet<>();
        for (int i = 0; i < n; i++) {
            uniqueParents.add(ds.findUParent(i));
        }

        int components = uniqueParents.size();
        int required = components - 1;

        return extraEdges >= required ? required : -1;
        
    }
}
public class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n){
        for(int i =0;i<n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    public int findUParent(int node){
        if(parent.get(node)==node){
            return node;
        }
        int ulp = findUParent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void unionByRank(int u,int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        if(ulp_u==ulp_v)return;
        if(rank.get(ulp_u)>rank.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
        }
        else if(rank.get(ulp_v)>rank.get(ulp_u)){
            parent.set(ulp_u,ulp_v);
        }
        else{
            parent.set(ulp_u,ulp_v);
            int RankU = rank.get(ulp_u);
            rank.set(ulp_u,RankU+1);
        }
    }
    public void unionBySize(int u,int v) {
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
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