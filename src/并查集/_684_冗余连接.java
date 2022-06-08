package 并查集;

public class _684_冗余连接 {
	public int[] findRedundantConnection(int[][] edges) {
        //并查集
        int nodeCount = edges.length;
        UF uf = new UF(nodeCount + 1);

        for (int i = 0; i < nodeCount; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (uf.find(node1) != uf.find(node2)) {
                uf.union(node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }
}
