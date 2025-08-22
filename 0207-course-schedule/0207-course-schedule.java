class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
         int[] indeg = new int[numCourses];
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:prereq){
            adj.get(arr[0]).add(arr[1]);
            indeg[arr[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<numCourses;i++){
            if(indeg[i]==0) q.offer(i);
        }
        int topo = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            topo++;
            for(Integer it:adj.get(curr)){
                indeg[it]--;
                if(indeg[it]==0){
                    q.offer(it);
                }
            }
        }
        return topo==numCourses;
    }
}