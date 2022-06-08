package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 面试题0807无重复字符串的排列组合 {
	List<String> list = new ArrayList<>();   

    public String[] permutation(String S) {
        StringBuilder path = new StringBuilder();
        boolean[] visited = new boolean[S.length()]; 
        dfs(S, path, visited);
        return list.toArray(new String[list.size()]);
    }

    private void dfs(String s, StringBuilder path, boolean[] visited) {
        if (s.length() == path.length()) {
            list.add(new String(path));
            //list.add(path.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {       
            //剪枝
            if (visited[i]) {
                continue;
            }
            //choose
            visited[i] = true;
            path.append(s.charAt(i));

            dfs(s, path, visited);
            //withdraw choice
            visited[i] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }
//	List<String> list = new ArrayList<>();
//    StringBuilder path = new StringBuilder();
//    public String[] permutation(String S) {
//        dfs(S, list, path);
//        return list.toArray(new String[list.size()]);
//    }
//
//    private void dfs(String s, List<String> list, StringBuilder path) {
//        if (s.length() == path.length()) {
//            list.add(new String(path));
//            return;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            String temp = new String(path);
//            if (temp.contains(s.charAt(i) + "")) {
//                continue;
//            }
//            path.append(s.charAt(i));
//            dfs(s, list, path);
//            path.deleteCharAt(path.length() - 1);
//        }
//    }
}
