class Solution {
    private int[][] directions = {
        {1, 0}, {-1, 0},
        {0, 1}, {0, -1},
        {1, 1}, {-1, -1},
        {1, -1}, {-1, 1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 2;

        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] curr = queue.poll();

                int row = curr[0];
                int col = curr[1];

                if (row == n - 1 && col == n - 1) {
                    return steps;
                }

                for (int[] dir : directions) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < n &&
                        grid[nr][nc] == 0 &&
                        grid[nr][nc]!=2) {

                        queue.offer(new int[]{nr, nc});
                        grid[nr][nc] = 2;
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}