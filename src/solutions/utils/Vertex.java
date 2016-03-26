package solutions.utils;

import java.util.ArrayList;

/**
 * Created by James on 3/24/16.
 */
public class Vertex {
    private int label;
    private ArrayList<Vertex> next = null;

    public Vertex(char lab) {
        label = lab;
    }

    public Vertex(char lab, ArrayList<Vertex> nxt) {
        label = lab;
        next = nxt;
    }

    public void addAdj(Vertex ver) {
        if (next == null) next = new ArrayList<Vertex>();
        next.add(ver);
    }

    public int getLabel() {
        return label;
    }

    public ArrayList<Vertex> getAdj() {
        return new ArrayList<Vertex>(next);
    }
}
