class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int row = times.length;
        int col = times[0].length;
        int t = 0;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] temp:times){
            int src = temp[0];
            int target = temp[1];
            int time = temp[2];
            adj.get(src-1).add(new int[]{target-1,time});
        }
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1]=0;
        PriorityQueue<Pair> q = new PriorityQueue<>((x,y)->x.first-y.first);
        q.add(new Pair(0,k-1));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int node = curr.second;
            int time = curr.first;
            for(int[] neighbour: adj.get(node)){
                int adjNode = neighbour[0];
                int edW = neighbour[1];
                if((time+edW)<dist[adjNode]){
                    dist[adjNode] = time+edW;
                    q.add(new Pair(dist[adjNode],adjNode));
                }
            }
            
        }
        for(int i:dist){
            if(i==Integer.MAX_VALUE) return -1;
            t=Math.max(t,i);
        }
        return t;


    }
    class Pair{
        int first,second;
        public Pair(int first, int second){
            this.first = first;//time
            this.second = second;//node
        }
    }
}