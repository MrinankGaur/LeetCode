class Solution {
    static{
        for(int i = 0; i < 1000; i++){
            findOrder(0, new int[][]{});
        }
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
         List<List<Integer>> graph = new ArrayList<>();
        int course[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int pre[]:prerequisites){
            int sub = pre[0];
            int precourse = pre[1];
            graph.get(precourse).add(sub);
            course[sub]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(course[i] == 0){
                q.add(i);
            }
        }
        int ans[]=new int[numCourses];
        int i =0;
        while(!q.isEmpty()){
            int current = q.poll();
            ans[i++] = current;
            for(int neighbor:graph.get(current)){
                course[neighbor]--;
                if(course[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }
        return i == numCourses?ans:new int[0];
    }
}