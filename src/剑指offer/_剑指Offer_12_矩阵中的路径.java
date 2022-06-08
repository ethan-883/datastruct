package 剑指offer;

public class _剑指Offer_12_矩阵中的路径 {
	//错在有固定的先后顺序，先上后下，
	public boolean exist(char[][] board, String word) {
		/*if (board == null || word == null) return false;
		char[] arr = word.toCharArray();
				
		int m = board.length, n = board[0].length;
		int arrLen = arr.length;
		
		boolean[][] used = new boolean[m][n];
		//找到首字母
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				//cur记录arr位置
				int cur = 0;
				if (arr[cur++] == board[i][j]) {
					//判断这个首字母是否可行
					used = new boolean[m][n];
					used[i][j] = true;
					int curi = i, curj = j;
					boolean flag = true;				
					while (cur < arrLen) {
						if (curi > 0 && board[curi - 1][curj] == arr[cur] && used[curi - 1][curj] == false) {						
							//up
							cur++;
							curi--;
						} else if (curi < m - 1 && board[curi + 1][curj] == arr[cur] && used[curi + 1][curj] == false) {							
							//down
							cur++;
							curi++;
						} else if (curj > 0 && board[curi][curj - 1] == arr[cur] && used[curi][curj - 1] == false) {							
							//left
							cur++;
							curj--;
						} else if (curj < n - 1 && board[curi][curj + 1] == arr[cur] && used[curi][curj + 1] == false) {
							//right
							cur++;
							curj++;							
						} else {
							flag = false;
							break;
						}
						used[curi][curj] = true;
					}
					if (flag == true) {
						return true;
					}
				}
			}
		}
		return false;*/
		char[] words = word.toCharArray();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, words, i, j, 0)) return true;
			}
		}
		return false;
	}
	
	boolean dfs(char[][] board, char[] word, int i, int j, int k) {
		if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
		if (k == word.length - 1) return true;
		board[i][j] = '\0';
		boolean res = dfs(board, word, i+1, j, k+1) || dfs(board, word, i-1, j, k+1) ||
				dfs(board, word, i, j+1, k+1) || dfs(board, word, i, j-1, k+1);
		board[i][j] = word[k];
		return res;
	}
}
