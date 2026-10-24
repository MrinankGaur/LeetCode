class Solution {

    class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int shortestPathBinaryMatrix(int[][] G) {
        Queue<Node> Q = new ArrayDeque<>();
        if (G[0][0] == 1) {
            return -1;
        }
        Q.add(new Node(0, 0));
        int n = G.length;
        if (n == 1) {
            return 1;
        }
        boolean[][] V = new boolean[n][n];
        V[0][0] = true;

        int[][] D = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };

        int moves = 1;
        while (!Q.isEmpty()) {
            int size = Q.size();
            moves++;
            for (int i = 0; i < size; i++) {
                Node node = Q.poll();
                int nx = node.x, ny = node.y;

                for (int j = 0; j < D.length; j++) {
                    int newx = nx + D[j][0], newy = ny + D[j][1];
                    if (newx >= 0 && newy >= 0 && newx < n && newy < n && G[newx][newy] == 0 && !V[newx][newy]) {
                        Q.add(new Node(newx, newy));
                        V[newx][newy] = true;
                        if (newx == n - 1 && newy == n - 1) {
                            return moves;
                        }
                    }
                }
            }
        }
        return -1;
    }
}