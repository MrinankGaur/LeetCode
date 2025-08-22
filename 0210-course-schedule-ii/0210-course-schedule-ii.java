class Solution {
    public int[] findOrder(int n, int[][] preq) {
        int[] indeg = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] arr:preq){
            adj.get(arr[1]).add(arr[0]);
            indeg[arr[0]]++;
        }
        int[] ans = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        int it = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            ans[it++] = curr;
            for(int node : adj.get(curr)){
                indeg[node]--;
                if(indeg[node]==0){
                    q.offer(node);
                }
            }
        }
        return it==n ? ans : new int[]{}; 
        
    }
}