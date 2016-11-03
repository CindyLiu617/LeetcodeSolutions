package solutions;



/**
 * Created by James on 6/4/16.
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        //union find
        int[] root = new int[n];
        //initiate every node's parent to 0, 1, ,,,n respectively.
        //precondition: Given n nodes labeled from 0 to n - 1
        for (int i = 1; i < n; ++i)
            root[i] = i;
        for (int[] edge : edges) {
            int root1 = _find(edge[0], root);
            int root2 = _find(edge[1], root);
            //the original roots are same before union, meaning they are
            // already connected, then if a new edge is added, a cycle is
            // created.
            if (root1 == root2)
                return false;
            //union: set edge[0]'s parent points to edge[1]
            //or root[root2] = root1
            root[root1] = root2;
        }
        return edges.length == n - 1;
    }

    //find original root
    private int _find(int node, int[] ids) {
        while (ids[node] != node)
            node = ids[node];
        return node;
    }

    static public class Test {
        static private GraphValidTree _solution = new GraphValidTree();

        static public void randomTest() {
            int[][] edges = {{15, 16}, {16, 17}};
            int n = 5;
            boolean rst = _solution.validTree(n, edges);
            System.out.println(rst);
        }
    }
}
