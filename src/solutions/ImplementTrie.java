package solutions;

import com.sun.scenario.effect.impl.sw.java.JSWPhongLighting_SPOTPeer;
import com.sun.tools.classfile.CharacterRangeTable_attribute;
import com.sun.tools.javac.code.Source;
import com.sun.tools.javac.comp.Annotate;
import solutions.utils.Trie;
import solutions.utils.TrieNode;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import sun.reflect.generics.tree.CharSignature;

import java.util.HashMap;

/**
 * Created by James on 11/1/16.
 */
public class ImplementTrie {
    private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0){
            throw new NotImplementedException();
        }
        TrieNode ptr;
        HashMap<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); ++i){
            char c = word.charAt(i);
            if (!children.containsKey(c)){
                ptr = new TrieNode(c);
                children.put(c, ptr);
            } else {
                ptr = children.get(c);
            }
            children = ptr.children;
            if (i == word.length() - 1){
                ptr.leaf = true;
            }
        }
    }

    // Returns if the word is in the trie.
    public TrieNode searchHelper(String word) {
        if (word == null || word.length() == 0){
            throw new NotImplementedException();
        }
        HashMap<Character, TrieNode> children = root.children;
        TrieNode ptr = null;
        for (int i = 0; i < word.length(); ++i){
            char c = word.charAt(i);
            if (!children.containsKey(c)){
                return null;
            } else {
                ptr = children.get(c);
                children = ptr.children;
            }
        }
        return ptr;
    }

    public boolean search(String word){
        if (word == null || word.length() == 0){
            throw new NotImplementedException();
        }
        TrieNode last = searchHelper(word);
        return last != null && last.leaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0){
            throw new NotImplementedException();
        }
        return searchHelper(prefix) != null;
    }

    static public class Test {
        static private ImplementTrie _solution = new ImplementTrie();

        static public void randomTest() {
            _solution.insert("lintcode");
            boolean r1 = _solution.search("lint");
            boolean r2 = _solution.startsWith("lint");
            System.out.println(r1);
            System.out.println(r2);
        }
    }
}
