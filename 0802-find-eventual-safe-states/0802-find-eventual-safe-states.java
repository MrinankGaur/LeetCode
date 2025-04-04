// class Solution {
//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         int V = graph.length;
//         int[] indegree = new int[V];
//         ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
//          for(int i=0;i<V;i++){
//             rev.add(new ArrayList<Integer>());
//          }
//         ArrayList<Integer> list = new ArrayList<>();
//         Queue<Integer> q = new LinkedList<>();
//         for(int i=0;i<V;i++){
//             for(int j:graph[i]){
//                 rev.get(j).add(i);
//             }
//         }
//          for(int i=0;i<V;i++){
//             for(int j:rev.get(i)){
//                 indegree[j]++;
//             }
//         }
//         for(int i = 0;i<V;i++){
//             if(indegree[i]==0){
//                 q.add(i);
//             }
//         }

//         while(!q.isEmpty()){
//             int node = q.poll();
//             list.add(node);
//             for(int i:rev.get(node)){
//                 indegree[i]--;
//                 if(indegree[i]==0){
//                     q.offer(i);
//                 }
//             }

//         }
//         Collections.sort(list);
//         return list;
//     }
    
// }
class Solution {
    private boolean dfs(int[][] graph,int[] states,int curr){
        if(states[curr]>0) return states[curr]==2;
        states[curr] = 1;
        for(int neighbor : graph[curr]){
            if(states[neighbor]==2){
                continue;
            }
            if(states[neighbor]==1 || !dfs(graph,states,neighbor)){
                return false;
            }
        }
        states[curr] = 2;
        return true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] states = new int[graph.length];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(dfs(graph,states,i)){
                list.add(i);
            }
        }
        return list;
    }
}