class Solution {
    public void solve(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int delrow[] = {-1, 0, +1, 0};
		int delcol[] = {0, 1, 0, -1};
		int vis[][] = new int[n][m];
		for(int j = 0 ; j<m;j++) {
			if(vis[0][j] == 0 && mat[0][j] == 'O') {
				dfs(0, j, vis, mat, delrow, delcol);
			}

			if(vis[n-1][j] == 0 && mat[n-1][j] == 'O') {
				dfs(n-1,j,vis,mat, delrow, delcol);
			}
		}

		for(int i = 0;i<n;i++) {

			if(vis[i][0] == 0 && mat[i][0] == 'O') {
				dfs(i, 0, vis, mat, delrow, delcol);
			}


			if(vis[i][m-1] == 0 && mat[i][m-1] == 'O') {
				dfs(i, m-1, vis, mat, delrow, delcol);
			}
		}
		for(int i = 0;i<n;i++) {
			for(int j= 0 ;j<m;j++) {
				if(vis[i][j] == 0 && mat[i][j] == 'O')
					mat[i][j] = 'X';
			}
		}
    }
    public void dfs(int row, int col,int vis[][],char mat[][], int delrow[], int delcol[]) {
		vis[row][col] = 1;
		int n = mat.length;
		int m = mat[0].length;

		for(int i = 0;i<4;i++) {
			int nrow = row + delrow[i];
			int ncol = col + delcol[i];

			if(nrow >=0 && nrow <n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 'O') {
				dfs(nrow, ncol, vis, mat, delrow, delcol);
			}
		}
	}
}