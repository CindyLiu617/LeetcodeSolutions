package solutions.utils;

import java.util.ArrayList;

public class UndirectedGraphNode {
    public int label;
    public ArrayList<UndirectedGraphNode> neighbours;
    public UndirectedGraphNode(int x) {
        label = x;
        neighbours = new ArrayList<UndirectedGraphNode>();
    }
}
