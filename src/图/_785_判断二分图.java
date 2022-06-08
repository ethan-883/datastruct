package 图;

import java.util.Arrays;

public class _785_判断二分图 {
	private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int PINK = 2;
    private int[] color;
    private boolean valid;

    public boolean isBipartite(int[][] graph) {
        valid = true;
        color = new int[graph.length];
        Arrays.fill(color, UNCOLORED);
        
        //题目中给定的无向图不一定保证连通，因此我们需要进行多次遍历
        //直到每一个节点都被染色，或确定答案为false为止
        for (int i = 0; i < graph.length && valid; i++) {
            if (color[i] == UNCOLORED) {
                dfs(i, RED, graph);
            }        
        }
        return valid;
    }

    private void dfs(int node, int c, int[][] graph) {
        color[node] = c;
        int cNei = c == RED ? PINK : RED;
        for (int neighbor : graph[node]) {
            if (color[neighbor] == UNCOLORED) {
                dfs(neighbor, cNei, graph);
            } else if (color[neighbor] != cNei) {
                valid = false;
                return;
            }
        }
    }
}
