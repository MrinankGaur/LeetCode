class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] answer = new int[numCourses];
        int index = 0;
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] degree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            graph.get(b).add(a);
            degree[a]++;
        }
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            answer[index++] = course;
            for (int next: graph.get(course)) {
                degree[next]--;
                if (degree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return (index == answer.length) ? answer : new int[0];
    }
}