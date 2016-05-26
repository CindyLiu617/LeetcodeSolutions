package solutions;
import java.nio.charset.MalformedInputException;
import java.util.*;

/**
 * Created by James on 5/7/16.
 */
public class WordLadderII {
//    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
//        List<List<String>> ladders = new ArrayList<List<String>>();
//        if (wordList == null || wordList.size() == 0)
//            return ladders;
//        List<String> path = new ArrayList<String>();
//        dfs(ladders, path, beginWord, endWord, wordList);
//        return ladders;
//    }
//
//    //String cur starts from String start
//    private void dfs(List<List<String>> ladders, List<String> path, String cur, String end, Set<String> wordList) {
//        path.add(cur);
//        if (!wordList.isEmpty()) {
//            char[] curChar = cur.toCharArray();
//            for (int i = 0; i < cur.length(); ++i) {
//                char prev = cur.charAt(i);
//                for (char c = 'a'; c <= 'z'; ++c) {
//                    if (c != prev) {
//                        curChar[i] = c;
//                        String newStr = String.valueOf(curChar);
//                        if (wordList.contains(newStr)) {
//                            wordList.remove(newStr);
//                            dfs(ladders, path, newStr, end, wordList);
//                            wordList.add(newStr);
//                        } else if (newStr.equals(end)) {
//                            path.add(end);
//                            ladders.add(new ArrayList<String>(path));
//                            path.remove(path.size() - 1);
//                        }
//                    }
//                }
//                curChar[i] = prev;
//            }
//        }
//        path.remove(path.size() - 1);
//    }

//    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//  build tree first, then find path. bfs + dfs:

    public List<List<String>> findLadders1(String start, String end, Set<String> wordList) {
        List<List<String>> ladders = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        HashMap<String, Integer> distance = new HashMap<String, Integer>();
        wordList.add(start);
        wordList.add(end);
        bfs(map, distance, start, wordList);
        List<String> path = new ArrayList<String>();
        dfs(ladders, path, end, start, distance, map);
        return ladders;
    }

    private void dfs(List<List<String>> ladders, List<String> path, String cur, String start, HashMap<String, Integer> distance,
                     HashMap<String, List<String>> map) {
        path.add(cur);
        if (cur.equals(start)) {
            Collections.reverse(path);
            ladders.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } else {
            for (String before : map.get(cur)) {
                if (distance.containsKey(before) && distance.get(cur) == distance.get(before) + 1)
                    dfs(ladders, path, before, start, distance, map);
            }
        }
        path.remove(path.size() - 1);
    }

    private void bfs(HashMap<String, List<String>> map, HashMap<String, Integer> distance,
                     String start, Set<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distance.put(start, 0);
        for (String s : dict) {
            map.put(s, new ArrayList<String>());
        }
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            List<String> nextList = generateList(cur, dict);
            for (String next : nextList) {
                map.get(next).add(cur);
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(cur) + 1);
                    queue.offer(next);
                }
            }
        }
    }

    private List<String> generateList(String cur, Set<String> dict) {
        List<String> expansion = new ArrayList<String>();
        char[] curChar = cur.toCharArray();
        for (int i = 0; i < cur.length(); ++i) {
            char prev = cur.charAt(i);
            for (char ch = 'a'; ch <= 'z'; ++ch) {
                if (ch != cur.charAt(i)) {
                    curChar[i] = ch;
                    String newStr = String.valueOf(curChar);
                    if (dict.contains(newStr))
                        expansion.add(newStr);
                }
            }
            curChar[i] = prev;
        }
        return expansion;
    }

//    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//    queue stores path; bfs only:

    public List<List<String>> findLadders2(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> ladders = new ArrayList<List<String>>();
        if (wordList == null || wordList.isEmpty())
            return ladders;
        List<String> path = new ArrayList<String>();
        path.add(beginWord);
        Queue<List<String>> myQ = new LinkedList<List<String>>();
        myQ.offer(path);
        wordList.remove(endWord);
        wordList.remove(beginWord);
        HashSet<String> newAdded = new HashSet<String>();
        int minLen = Integer.MAX_VALUE;
        while (!myQ.isEmpty()){
            int size = myQ.size();
//            this is fucking important!!!
//            reach the size of the queue means finish traversing one layer
            for (int i = 0; i < size; ++i){
                List<String> cur = myQ.poll();
                String last = cur.get(cur.size() - 1);
                char[] lastChar = last.toCharArray();
                for (int j = 0; j < beginWord.length(); ++j){
                    char prev = last.charAt(j);
                    for (char c = 'a'; c <= 'z'; ++c){
                        if (c != last.charAt(j)){
                            lastChar[j] = c;
                            String newLast = String.valueOf(lastChar);
                            if (wordList.contains(newLast)){
                                List<String> curCopy = new ArrayList<String>(cur);
                                curCopy.add(newLast);
                                newAdded.add(newLast);
                                myQ.offer(curCopy);
                            } else if (newLast.equals(endWord)){
                                List<String> curCopy = new ArrayList<String>(cur);
                                curCopy.add(endWord);
                                if (curCopy.size() <= minLen){
                                    ladders.add(new ArrayList<String>(curCopy));
                                    minLen = curCopy.size();
                                }
                                curCopy.remove(path.size() - 1);
                            }
                        }
                    }
                    lastChar[j] = prev;
                }
            }
            for (String added: newAdded){
                    wordList.remove(added);
                }
        }
        return ladders;
    }

//    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//  two sided bfs search:

    public List<List<String>> findLaddersTwoSidedBFS(String start, String end, Set<String> dict) {
        // hash set for both ends
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();

        // initial words in both ends
        set1.add(start);
        set2.add(end);

        // we use a map to help construct the final result
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        // build the map
        helper(dict, set1, set2, map, false);

        List<List<String>> res = new ArrayList<List<String>>();
        List<String> sol = new ArrayList<String>(Collections.singletonList(start));

        // recursively build the final result
        generateList(start, end, map, sol, res);

        return res;
    }

    boolean helper(Set<String> dict, Set<String> set1, Set<String> set2, Map<String, List<String>> map, boolean flip) {
        if (set1.isEmpty()) {
            return false;
        }

        if (set1.size() > set2.size()) {
            return helper(dict, set2, set1, map, !flip);
        }

        // remove words on current both ends from the dict
        dict.removeAll(set1);
        dict.removeAll(set2);

        // as we only need the shortest paths
        // we use a boolean value help early termination
        boolean done = false;

        // set for the next level
        Set<String> set = new HashSet<String>();

        // for each string in end 1
        for (String str : set1) {
            for (int i = 0; i < str.length(); i++) {
                char[] chars = str.toCharArray();

                // change one character for every position
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;

                    String word = new String(chars);

                    // make sure we construct the tree in the correct direction
                    String key = flip ? word : str;
                    String val = flip ? str : word;

                    List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<String>();

                    if (set2.contains(word)) {
                        done = true;

                        list.add(val);
                        map.put(key, list);
                    }

                    if (!done && dict.contains(word)) {
                        set.add(word);

                        list.add(val);
                        map.put(key, list);
                    }
                }
            }
        }

        // early terminate if done is true
        return done || helper(dict, set2, set, map, !flip);
    }

    void generateList(String start, String end, Map<String, List<String>> map, List<String> sol, List<List<String>> res) {
        if (start.equals(end)) {
            res.add(new ArrayList<String>(sol));
            return;
        }

        // need this check in case the diff between start and end happens to be one
        // e.g "a", "c", {"a", "b", "c"}
        if (!map.containsKey(start)) {
            return;
        }

        for (String word : map.get(start)) {
            sol.add(word);
            generateList(word, end, map, sol, res);
            sol.remove(sol.size() - 1);
        }
    }

//    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        static public class Test {
        static private WordLadderII _solution = new WordLadderII();

        static public void randomTest() {
//            Set<String> wordList = new HashSet<String>();
//            wordList.add("hot");
//            wordList.add("dot");
//            wordList.add("dog");
//            wordList.add("lot");
//            wordList.add("log");
//            List<List<String>> ans = _solution.findLadders1("hit", "cog", wordList);
//            for (int i = 0; i < ans.size(); ++i) {
//                for (int j = 0; j < ans.get(i).size(); ++j) {
//                    System.out.print(ans.get(i).get(j));
//                }
//                System.out.println();
//            }
//            System.out.println(">>>>>>>>>>>>>>");
//

//            Set<String> wordList2 = new HashSet<String>();
//            wordList2.add("a");
//            wordList2.add("b");
//            wordList2.add("c");
//            List<List<String>> ans2 = _solution.findLadders1("a", "c", wordList2);
//            for (int i = 0; i < ans2.size(); ++i) {
//                for (int j = 0; j < ans2.get(i).size(); ++j) {
//                    System.out.print(ans2.get(i).get(j));
//                }
//                System.out.println();
//            }
//            System.out.println(">>>>>>>>>>>>>>");
//
//            Set<String> wordList3 = new HashSet<String>();
//            wordList3.add("hot");
//            wordList3.add("cog");
//            wordList3.add("dog");
//            wordList3.add("tot");
//            wordList3.add("hog");
//            wordList3.add("hop");
//            wordList3.add("pot");
//            wordList3.add("dot");
//            List<List<String>> ans3 = _solution.findLadders1("hot", "dog", wordList3);
//            for (int i = 0; i < ans3.size(); ++i) {
//                for (int j = 0; j < ans3.get(i).size(); ++j) {
//                    System.out.print(ans3.get(i).get(j));
//                }
//                System.out.println();
//            }
//            System.out.println(">>>>>>>>>>>>>>");
//
//            Set<String> wordList4 = new HashSet<String>();
//            wordList4.add("ted");
//            wordList4.add("tex");
//            wordList4.add("red");
//            wordList4.add("tax");
//            wordList4.add("tad");
//            wordList4.add("den");
//            wordList4.add("rex");
//            wordList4.add("pee");
//            List<List<String>> ans4 = _solution.findLadders1("red", "tax", wordList4);
//            for (int i = 0; i < ans4.size(); ++i) {
//                for (int j = 0; j < ans4.get(i).size(); ++j) {
//                    System.out.print(ans4.get(i).get(j));
//                }
//                System.out.println();
//            }
//            System.out.println(">>>>>>>>>>>>>>");

            Set<String> wordList5 = new HashSet<String>();
            wordList5.add("hot");
            wordList5.add("dot");
            wordList5.add("dog");
            List<List<String>> ans5 = _solution.findLaddersTwoSidedBFS("dog", "hot", wordList5);
            for (int i = 0; i < ans5.size(); ++i) {
                for (int j = 0; j < ans5.get(i).size(); ++j) {
                    System.out.print(ans5.get(i).get(j));
                }
                System.out.println();
            }
            System.out.println(">>>>>>>>>>>>>>");
        }
    }
}

