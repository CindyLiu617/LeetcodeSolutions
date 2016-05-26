package solutions.utils;

import java.util.HashMap;

/**
 * Created by James on 5/16/16.
 */
public class TrieNode {
    char c;
    boolean leaf;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    public TrieNode(char c){
        this. c = c;
    }
    public TrieNode(){}
}
