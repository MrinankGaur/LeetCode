class Solution {
    public int removeStones(int[][] stones) {
        if(stones.length<=1) return 0;
        int n = stones.length;
        DisjointSet ds = new DisjointSet(n);
        int cnt=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int[] node1 = stones[i];
                int[] node2 = stones[j];
                if(node1[0]==node2[0] || node1[1]==node2[1]){
                    ds.unionBySize(i,j);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(ds.findUParent(i)==i) cnt++;
        }
        return n-cnt;
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