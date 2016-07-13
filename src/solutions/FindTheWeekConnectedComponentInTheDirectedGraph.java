package solutions;

import solutions.utils.DirectedGraphNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by James on 7/10/16.
 */
public class FindTheWeekConnectedComponentInTheDirectedGraph {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (DirectedGraphNode node : nodes) {
            map.put(node.label, node.label);
        }
        for (DirectedGraphNode node : nodes) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                union(node.label, neighbor.label);
            }
        }
        Map<Integer, List<Integer>> components = new HashMap<Integer, List<Integer>>();
        for (DirectedGraphNode node : nodes) {
            List<Integer> nodesList;
            int root = find(node.label);
            if (components.containsKey(root)) {
                nodesList = components.get(root);
            } else {
                nodesList = new ArrayList<Integer>();
            }
            nodesList.add(node.label);
            components.put(root, nodesList);
        }
        for (List<Integer> nodesList : components.values()) {
            result.add(nodesList);
        }
        return result;
    }

    private int find(int label) {
        while (label != map.get(label)) {
            map.put(label, map.get(label));
            label = map.get(label);
        }
        return label;
    }

    private void union(int label1, int label2) {
        int root1 = find(label1);
        int root2 = find(label2);
        map.put(root1, root2);
    }
}
