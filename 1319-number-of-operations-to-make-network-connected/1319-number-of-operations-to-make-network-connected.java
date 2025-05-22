class Solution {
    class DSU {
        int [] parent;
        int [] size;
        int noOfComponents;

        public DSU(int n){
            noOfComponents = n;
            parent = new int [n];
            size = new int [n];
            for(int i=0; i<n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public boolean union(int n1, int n2){
            int p1 = find(n1);
            int p2 = find(n2);

            if(p1 == p2){
                return false;
            }

            // merge needs to happen
            if(size[p1] > size[p2]){
                parent[p2] = p1;
                size[p1] += size[p2];
            } else {
                parent[p1] = p2;
                size[p2] += size[p1];
            }
            noOfComponents--;

            return true;
        }

        public int find(int n){
            int p = parent[n];
            if(p != n){
                p = find(p);
                parent[n] = p;
            }
            return p;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        DSU dsu = new DSU(n);
        int extraCable = 0;

        for(int [] connection : connections){
            if(!dsu.union(connection[0], connection[1])){
                extraCable++;
            }
        }


        int components = 0;
        for(int i=0; i<dsu.parent.length; i++){
            if(dsu.parent[i] == i){
                components++;
            }
        }

        return extraCable >= components - 1 ? components - 1 : -1;
    }
}