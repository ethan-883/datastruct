package 并查集;

public class _130_被围绕的区域 {
	//并查集
	public void solve(char[][] board) {
		if (board == null) {
			return;
		}
		int m = board.length;
		int n = board[0].length;
		UF uf = new UF(n * m + 1);
		int dummy = n * m;
		//左右两列
		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O') {
				uf.union(i * n, dummy);
			}
			if (board[i][n - 1] == 'O') {
				uf.union(i * n + n - 1, dummy);
			}
		}
		//上下两行
		for (int j = 0; j < n; j++) {
			if (board[0][j] == 'O') {
				uf.union(j, dummy);
			}
			if (board[m-1][j] == 'O') {
				uf.union(n * (m-1) + j, dummy);
			}
		}
		int[][] d = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
		for (int i = 1; i < m -1; i++) {
			for (int j = 1; j < n - 1; j++) {
				if (board[i][j] == 'O') {
					for (int k = 0; k < 4; k++) {
						int x = i + d[k][0];
						int y = j + d[k][1];
						if (board[x][y] == 'O') {
							uf.union(x * n + y, i * n + j);
						}
					}
				}
			}
		}
		
		for (int i = 1; i < m - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				if (uf.connected(dummy, i * n + j)) {
					board[i][j] = 'X';
				}
			}
		}
		
	}
	
	//dfs
    /*int n, m;
    public void solve(char[][] board) {
        n = board.length;
        if (n == 0) {
            return;
        }
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m - 1);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(board, 0, i);
            dfs(board, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }*/
}

class UF{
	private int[] parent;
	private int count;
	private int[] size;
	public UF(int n) {
		this.count = n;
		parent = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}
	
	//x的父节点为parent[x]
    public int find(int x) {
        while (parent[x] != x) {
            //会修改parent[x]
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
	
	public boolean connected(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		return rootP == rootQ;
	}
	
	public int count() {
		return count;
	}
	
	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ) {
			return;
		}
		
		if (size[rootP] > size[rootQ]) {
			parent[rootQ] = rootP;
			size[rootP] += size[rootQ];
		} else {
			parent[rootP] = rootQ;
			size[rootQ] += size[rootP];
		}
		count--;		
	}
}

