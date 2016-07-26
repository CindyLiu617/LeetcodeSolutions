package solutions;



import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by James on 5/9/16.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (wordList == null || wordList.isEmpty())
            return 0;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        wordList.remove(endWord);
        int len = 1;
        while (!queue.isEmpty()){
            //this is fucking important!!!
            int count = queue.size();
            for (int i= 0; i < count; ++i){
                String cur = queue.poll();
                for (char c = 'a'; c <= 'z'; ++c){
                    for (int j = 0; j < cur.length(); ++j){
                        if (c == cur.charAt(j))
                            continue;
                        String tempt = change(cur, j, c);
                        if (tempt.equals(endWord))
                            return len + 1;
                        if (wordList.contains(tempt)){
                            queue.offer(tempt);
                            wordList.remove(tempt);
                        }
                    }
                }
            }
            ++len;
        }
        return 0;
    }
    private String change(String s, int index, char c){
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    static public class Test {
        static private WordLadder _solution = new WordLadder();

        static public void test(String beginWord, String endWord, Set<String> wordDict, int ans) {
            assert ans == _solution.ladderLength(beginWord, endWord, wordDict);
        }

        static public void randomTest() {
            Set<String> wordList = new HashSet<String>();
            wordList.add("hot");
            wordList.add("dot");
            wordList.add("dog");
            wordList.add("lot");
            wordList.add("log");
            test("hit", "cog", wordList, 5);
        }
    }
}
