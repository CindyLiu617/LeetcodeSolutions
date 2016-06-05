package solutions;

import solutions.utils.Trie;

import java.util.*;

/**
 * Created by James on 5/16/16.
 */
public class WordSearchII {
    public List<String> findWords (char[][] board, String[] words) {
        Set<String> res = new HashSet<String>();
        if (board==null || words==null || board.length==0 || words.length==0)
            return new ArrayList<String>(res);
        boolean[][] visited = new boolean[board.length][board[0].length];

        Trie trie = new Trie();
        for (String word: words)
            trie.insert(word);

        for (int i = 0; i < board.length; ++i){
            for (int j = 0; j < board[0].length; ++j){
                search(board, visited, trie, i, j, new StringBuilder(), res);
            }
        }
        return new ArrayList<String>(res);
    }
    private void search(char[][] board, boolean[][] visited, Trie trie, int i, int j, StringBuilder sb, Set<String> res){
        if (i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || visited[i][j])
            return;
        sb.append(board[i][j]);
        String s = sb.toString();
        visited[i][j] = true;
        if (trie.startsWith(s)){
            if (trie.search(s))
                res.add(s);
            search(board, visited, trie, i-1, j, sb, res);
            search(board, visited, trie, i+1, j, sb, res);
            search(board, visited, trie, i, j-1, sb, res);
            search(board, visited, trie, i, j+1, sb, res);
        }
        sb.deleteCharAt(sb.length() - 1);
        visited[i][j] = false;
    }
    static public class Test {
        static private WordSearchII _solution = new WordSearchII();

        static public void randomTest() {
            char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
            String[] words = {"oath","pea","eat","rain"};
            List<String> rst = _solution.findWords(board, words);
            for (int i = 0; i < rst.size(); ++i){
                System.out.println(rst.get(i));
            }
        }
    }
}

