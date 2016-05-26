package solutions.utils;

import java.util.HashMap;
/**
 * Created by James on 5/16/16.
 */
public class Trie {
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t;
        for (int i = 0; i < word.length(); ++i){
            char c = word.charAt(i);
            if (children.containsKey(c))
                t = children.get(c);
            else {
                t = new TrieNode(c);
                children.put(c, t);
            }
            children = t.children;
            if (i == word.length() - 1)
                t.leaf = true;
        }
    }
    public boolean search(String word){
        TrieNode t = searchNode(word);
        return t != null && t.leaf;
    }
    public boolean startsWith(String prefix){
        return searchNode(prefix) != null;
    }
    private TrieNode searchNode(String word){
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for (int i = 0; i < word.length(); ++i){
            char c = word.charAt(i);
            if (!children.containsKey(c))
                return null;
            t = children.get(c);
            children = t.children;
        }
        return t;
    }
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("ab");
        trie.insert("ac");
        trie.insert("ad");
    }
}
