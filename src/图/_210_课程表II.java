package 图;

import java.util.ArrayList;
import java.util.List;

public class _210_课程表II {
	//拓扑排序
	//存储有向图
    List<List<Integer>> edges;
    //0 未搜索 1 搜索中 2 已完成
    int[] visited;
    //数组模拟栈，n - 1栈底 0 栈顶
    int[] result;
    //图中是否有环
    boolean valid = true;
    //栈下标
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        result = new int[numCourses];
        index = numCourses - 1;
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        //挑一个未搜索节点进行dfs
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!valid) {
            return new int[0];
        }
        //无环则存在拓扑排序
        return result;
    }

    private void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            //未搜索则搜索相邻节点
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                //搜索中，找到了环
                valid = false;
                return;
            }          
        }
        visited[u] = 2;
        result[index--] = u;
    }
}
