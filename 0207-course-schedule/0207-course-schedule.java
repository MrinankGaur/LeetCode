class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:prereq){
            int u = arr[0];
            int v = arr[1];
            adj.get(u).add(v);
        }
        int[] indeg = new int[numCourses];
        for(int i =0;i<numCourses;i++){
            for(int it:adj.get(i)){
                indeg[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<numCourses;i++){
            if(indeg[i]==0) q.offer(i);
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            topo.add(curr);
            for(Integer it:adj.get(curr)){
                indeg[it]--;
                if(indeg[it]==0){
                    q.offer(it);
                }
            }
        }
        return topo.size()==numCourses;



    }
}