package solutions;

import solutions.utils.DirectedGraphNode;

import java.util.*;

public class FindTheWeakConnectedComponentInTheDirectedGraph {
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */

    private HashMap<Integer, Integer> rootMap;
    private HashSet<Integer> set;
    private HashMap<Integer, List<Integer>> listMap;

    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nodes == null || nodes.size() == 0) {
            return rst;
        }
        //use the property of set which is do not have duplicate element.
        set = new HashSet<Integer>();
        for (DirectedGraphNode node : nodes) {
            set.add(node.label);
            for (DirectedGraphNode neighbor : node.neighbors) {
                set.add(neighbor.label);
            }
        }
        //prepare
        rootMap = new HashMap<Integer, Integer>();
        for (int num : set) {
            rootMap.put(num, num);
        }
        //union-find
        for (DirectedGraphNode node : nodes) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                _union(node.label, neighbor.label);
            }
        }
        generateRst(rst, set);
        return rst;
    }

    private void _union (int vertex1, int vertex2) {
        int root1 = _findRoot(vertex1);
        int root2 = _findRoot(vertex2);
        if (root1 != root2) {
            rootMap.put(root1, root2);
        }
    }

    private int _findRoot (int vertex) {
       while (!rootMap.get(vertex).equals(rootMap.get(rootMap.get(vertex)))) {
            rootMap.put(vertex, rootMap.get(rootMap.get(vertex)));
       }
       return rootMap.get(vertex);
    }

    private int _compressedFindRoot (int vertex) {
        int root = rootMap.get(vertex);
        while (root != rootMap.get(root)) {
            root = rootMap.get(root);
        }
        int tmp, updatedRoot = rootMap.get(vertex);
        while (updatedRoot != rootMap.get(updatedRoot)) {
            tmp = rootMap.get(updatedRoot);
            rootMap.put(updatedRoot, root);
            updatedRoot = tmp;
        }
        return root;
    }

    private void generateRst (List<List<Integer>> rst, HashSet<Integer> set) {
        listMap = new HashMap<Integer, List<Integer>>();
        for (int num : set) {
            //!!
            int root = _findRoot(num);
            if (!listMap.containsKey(root)) {
                listMap.put(root, new ArrayList<Integer>());
            }
            listMap.get(root).add(num);
        }
        for (List<Integer> connectedComponent : listMap.values()) {
            Collections.sort(connectedComponent);
            rst.add(connectedComponent);
        }
    }

    static public class Test {
        static private FindTheWeakConnectedComponentInTheDirectedGraph _solution = new FindTheWeakConnectedComponentInTheDirectedGraph();

        static public void randomTest() {
            ArrayList<DirectedGraphNode> nodes =  new
                    ArrayList<DirectedGraphNode>();
            DirectedGraphNode n1 = new DirectedGraphNode(1);
            DirectedGraphNode n2 = new DirectedGraphNode(2);
            DirectedGraphNode n3 = new DirectedGraphNode(3);
            DirectedGraphNode n4 = new DirectedGraphNode(4);
            DirectedGraphNode n5 = new DirectedGraphNode(5);
            DirectedGraphNode n6 = new DirectedGraphNode(6);
            n1.neighbors.add(n2);
            n1.neighbors.add(n3);
            n2.neighbors.add(n3);
            n4.neighbors.add(n5);
            n6.neighbors.add(n5);
            nodes.add(n1);
            nodes.add(n2);
            nodes.add(n3);
            nodes.add(n4);
            nodes.add(n5);
            nodes.add(n6);
            List<List<Integer>>  rst = _solution.connectedSet2(nodes);
            for (int i = 0; i < rst.size(); ++i) {
                for (int j = 0; j < rst.get(i).size(); ++j) {
                    System.out.println(rst.get(i).get(j));
                }
                System.out.println(">>>>");
            }
        }
    }
}
