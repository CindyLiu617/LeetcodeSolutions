package solutions;
import solutions.utils.UndirectedGraphNode;

import java.util.*;

public class FindTheConnectedComponentInTheUndirectedGraph {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    HashMap<Integer, Integer> rootMap;
    HashSet<Integer> set;
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nodes == null || nodes.size() == 0) {
            return rst;
        }
        set = new HashSet<Integer>();
        for (UndirectedGraphNode node : nodes) {
            set.add(node.label);
            for (UndirectedGraphNode neighbor : node.neighbours) {
                set.add(neighbor.label);
            }
        }
        rootMap = new HashMap<Integer, Integer>();
        for (int num : set) {
           rootMap.put(num, num);
        }
        for (UndirectedGraphNode node : nodes) {
            for (UndirectedGraphNode neighbor : node.neighbours) {
                int nodeRoot = _find(node.label);
                int neiRoot = _find(neighbor.label);
                if (nodeRoot != neiRoot) {
                    _union(node.label, neighbor.label);
                }
            }
        }
        generateRst(rst, set);
        return rst;
    }

    private int _find(int vertex) {
        int root = rootMap.get(vertex);
        while (root != rootMap.get(root)) {
           root = rootMap.get(root);
        }
        return root;
    }

    private void _union (int vertex1, int vertex2) {
        int root1 = _find(vertex1);
        int root2 = _find(vertex2);
        if (root1 != root2) {
            rootMap.put(root1, root2);
        }
    }

    private void generateRst (List<List<Integer>> rst, HashSet<Integer> set) {
        HashMap<Integer, List<Integer>> listMap = new HashMap<Integer,
                List<Integer>>();
        for (int num : set) {
            int root = _find(num);
            if (!listMap.containsKey(root)) {
                listMap.put(root, new ArrayList<Integer>());
            }
            listMap.get(root).add(num);
        }
        for (List<Integer> list: listMap.values()) {
            Collections.sort(list);
            rst.add(list);
        }
    }

    static public class Test {
        static private FindTheConnectedComponentInTheUndirectedGraph
                _solution = new FindTheConnectedComponentInTheUndirectedGraph();

        static public void randomTest() {
            ArrayList<UndirectedGraphNode> nodes =  new
                    ArrayList<UndirectedGraphNode>();
            UndirectedGraphNode n1 = new UndirectedGraphNode(1);
            UndirectedGraphNode n2 = new UndirectedGraphNode(2);
            UndirectedGraphNode n3 = new UndirectedGraphNode(3);
            UndirectedGraphNode n4 = new UndirectedGraphNode(4);
            UndirectedGraphNode n5 = new UndirectedGraphNode(5);
            UndirectedGraphNode n6 = new UndirectedGraphNode(6);
            n1.neighbours.add(n2);
            n1.neighbours.add(n3);
            n2.neighbours.add(n3);
            n4.neighbours.add(n5);
            n6.neighbours.add(n5);
            nodes.add(n1);
            nodes.add(n2);
            nodes.add(n3);
            nodes.add(n4);
            nodes.add(n5);
            nodes.add(n6);
            List<List<Integer>>  rst = _solution.connectedSet(nodes);
            for (int i = 0; i < rst.size(); ++i) {
                for (int j = 0; j < rst.get(i).size(); ++j) {
                    System.out.println(rst.get(i).get(j));
                }
                System.out.println(">>>>");
            }
        }
    }
}
