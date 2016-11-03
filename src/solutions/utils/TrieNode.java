package solutions.utils;

import java.util.HashMap;

/**
 * Created by James on 5/16/16.
 */
public class TrieNode {
    public char c;
    public boolean leaf;
    public HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    public TrieNode(char c){
        this. c = c;
    }
    public TrieNode(){}
}
