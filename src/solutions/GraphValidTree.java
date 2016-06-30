package solutions;

import com.sun.tools.javac.util.Assert;

/**
 * Created by James on 6/4/16.
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        int[] ids = new int[n];
        for (int i = 1; i < n; ++i)
            ids[i] = i;
        for (int[] edge : edges) {
            int root1 = _find(edge[0], ids);
            int root2 = _find(edge[1], ids);
            if (root1 == root2)
                return false;
            ids[root2] = root1;
        }
        return edges.length == n - 1;
    }

    private int _find(int node, int[] ids) {
        while (ids[node] != node)
            node = ids[node];
        return node;
    }
    static public class Test {
        static private GraphValidTree _solution = new GraphValidTree();

        static public void test(int n, int[][] edges, boolean ans) {
            Assert.check(ans == (_solution.validTree(n, edges)));
        }

        static public void randomTest() {
            int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
            int n = 5;
            test(n, edges, false);
        }
    }
}
