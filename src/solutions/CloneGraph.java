package solutions;

import solutions.utils.UndirectedGraphNode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CloneGraph {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        map.put(node, newHead);
        queue.add(node);

        while(!queue.isEmpty()){
            UndirectedGraphNode ptr = queue.poll();
            for (UndirectedGraphNode neighbor: ptr.neighbors) {
                UndirectedGraphNode copyNeighbor;
                if (!map.containsKey(neighbor)) {
                    queue.add(neighbor);
                    copyNeighbor = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, copyNeighbor);
                }
                map.get(ptr).neighbors.add(map.get(neighbor));
            }
        }

        return newHead;
    }

    static public class Test {
        static private CloneGraph _solution = new CloneGraph();

        static public void randomTest() {
            UndirectedGraphNode node1 = new UndirectedGraphNode(1);
            UndirectedGraphNode node0 = new UndirectedGraphNode(0);
            UndirectedGraphNode node2 = new UndirectedGraphNode(2);
            node1.neighbors.add(node0);
            node1.neighbors.add(node2);
            node0.neighbors.add(node1);
            node0.neighbors.add(node2);
            node2.neighbors.add(node0);
            node2.neighbors.add(node1);
            node2.neighbors.add(node2);
            UndirectedGraphNode head = _solution.cloneGraph(node1);
        }
    }
}
