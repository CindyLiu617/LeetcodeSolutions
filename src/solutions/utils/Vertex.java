package solutions.utils;

import java.util.ArrayList;

/**
 * Created by James on 3/24/16.
 */
public class Vertex {
    private int label;
    private ArrayList<Vertex> neighbors = null;

    public Vertex(int lab) {
        label = lab;
    }

    public Vertex(int lab, ArrayList<Vertex> neighb) {
        label = lab;
        neighbors = neighb;
    }

    public void addAdj(Vertex ver) {
        if (neighbors == null) neighbors = new ArrayList<Vertex>();
        neighbors.add(ver);
    }

    public int getLabel() {
        return label;
    }

    public ArrayList<Vertex> getAdj() {
        return neighbors == null? null : new ArrayList<Vertex>(neighbors);
    }
}
