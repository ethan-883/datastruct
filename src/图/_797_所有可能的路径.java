package 图;

import java.util.LinkedList;
import java.util.List;

public class _797_所有可能的路径 {
	//本质是N叉树遍历
	List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    private void traverse(int[][] graph, int s, LinkedList<Integer> path) {
        path.add(s);
        int n = graph.length;
        if (s == n - 1) {
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        for (Integer child : graph[s]) {            
            traverse(graph, child, path);
        }
        path.removeLast();
    }
}
