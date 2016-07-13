package solutions.utils;

import java.util.ArrayList;

/**
 * Created by James on 7/10/16.
 */
public class DirectedGraphNode {
    public int label;
    public ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x){
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}
