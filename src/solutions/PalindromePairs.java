package solutions;
import com.sun.deploy.net.proxy.pac.PACFunctionsImpl;

import java.util.*;

/**
 * Created by James on 7/5/16.
 */
//time limit exceeded...
//public class PalindromePairs {
//    private List<List<Integer>> palinPairs = new ArrayList<List<Integer>>();
//    private List<Integer> pair = new ArrayList<Integer>();
//    private Set<List<Integer>> record = new HashSet<List<Integer>>();
//
//    public List<List<Integer>> palindromePairs(String[] words) {
//        if (words == null || words.length <= 1){
//            return null;
//        }
//        int wordsLen = words.length;
//        for (int i = 0; i < wordsLen; ++i){
//            for (int j = 0; j < wordsLen; ++j){
//                if (i == j){
//                    continue;
//                }
//                if ((record.contains(Arrays.asList(i, j)) || record.contains(Arrays.asList(j, i))) && (words[i].length() == words[j].length() || words[i].length() == 0 || words[j].length() == 0)){
//                    continue;
//                }
//                String temptStr = words[i] + words[j];
//                if (isPalindrome(temptStr)){
//                    createPalinPairs(i, j);
//                    if (words[i].length() == words[j].length() || words[i].length() == 0 || words[j].length() == 0){
//                        createPalinPairs(j, i);
//                    }
//                }
//            }
//        }
//        return palinPairs;
//    }
//
//    private void createPalinPairs(int index1, int index2){
//        pair.add(index1);
//        pair.add(index2);
//        record.add(new ArrayList<Integer>(pair));
//        palinPairs.add(new ArrayList<Integer>(pair));
//        pair.clear();
//    }
//
//    private boolean isPalindrome(String s) {
//        int frontPtr = 0;
//        int backPtr= s.length() - 1;
//        if (s.isEmpty()){
//            return true;
//        }
//        s = s.toLowerCase();
//        while(frontPtr < backPtr){
//            while (!Character.isLetterOrDigit(s.charAt(frontPtr)) && (frontPtr < backPtr)){
//                ++frontPtr;
//            }
//            while (!Character.isLetterOrDigit(s.charAt(backPtr)) && (frontPtr < backPtr)){
//                --backPtr;
//            }
//            if (s.charAt(frontPtr) != s.charAt(backPtr)){
//                return false;
//            }
//            ++frontPtr;
//            --backPtr;
//        }
//        return true;
//    }
//
//    static public class Test {
//        static private PalindromePairs _solution = new PalindromePairs();
//
//        static public void randomTest() {
//            String[] words1 = {"bat", "tab", "cat"};
//            List<List<Integer>> rst1 = _solution.palindromePairs(words1);
//            for (List<Integer> pair: rst1){
//                System.out.println(pair);
//            }
//            System.out.println("******************");
//
//            String[] words2 = {"abcd", "dcba", "lls", "s", "sssll"};
//            List<List<Integer>> rst2 = _solution.palindromePairs(words2);
//            for (List<Integer> pair: rst2){
//                System.out.println(pair);
//            }
//            System.out.println("******************");


//            String[] words3 = {"bbbbbabbabbbb","baabbaa","bbab","bbbabbaaab","abababbbbbab","abb",
//                    "baaaabbb","babbaaaba","aab","aaaab","baabbbbabbaaaba","baaab","abbbab","abaabbbabbabba",
//                    "aa","aabbbaabba","aaabbbbbaaabbbb","bbaaaaba","ababaaa","aaaaa","aaaaabbbbaaaba",
//                    "abbabbbaabbaabbb","bbaba","aaaaabbbabbbbaaaab","abbbaa","bbbabbaaa","bbbaaabaabbbaaaaabaa",
//                    "aaaabbabb","ababbababbbab","aaaaababaababbbabaaa","ba","bbbbababbbabab","baaaba",
//                    "aababbaaabbb","aabbaaabbabaaababaab","abbbb","babaabaaababb","bbbbabaaaab",
//                    "babbbbb","babaaba","aaba","abababba","a","bb","abaaab","babbabaababbabaaba",
//                    "aaaaaababbbabaaabaa","baabaaabb","b","bbaaaabbb","abaaaaabaabbbaa","ab",
//                    "bababaaaba","aabababb","ababaabbaababba","bbb","ababbaabababbbbbabb","bbbbb"
//                    ,"abbbbaabaaaabb","baba","bbaabbabaaababaabbaa","bbaabaabbabbaab","bbbaabbab",
//                    "babbbbbaaaaabaa","abbbbbbabbbabb","abaa","bbbbaababaab","abaaababa",
//                    "aaaababaaababbaaba","bbabbbabbbbbbaab","abbabbabaabbabbbba","abbbbbaabbbaaabaaaa",
//                    "bbaabababb","aaabababaabbaaaaaaab","ababbaabaaababb","abbbbabaaabbaaabbab",
//                    "aababababbabaaa","baabbaabbbaaaaaa","bbbbbbbabbabbbbbb","bbbabbabbabbabaabba",
//                    "babbbbabaaaabbabaab","baabaabaabababaaabba","bbaaaabbbbabbbaaaa","aaaaabaabaa",
//                    "bbabaaabbbabaa","baaabaaaaaab","ababbbbbbbabaaaba","abbbabaababbbbbaaa","baaaaaabab",
//                    "aabbabba","baaabbaabbbbaba","aaaaabba","babaaabbba","bbbbab","bbbbaabbaabab","baa",
//                    "baababaa","abbbbb","babbaa","abbbabbaa"};
//            String[] words3 = {"bbbbbabbabbbb", "b"};

//            System.out.println(words3[32]);
//            System.out.println(words3[44]);
//            List<List<Integer>> rst3 = _solution.palindromePairs(words3);
//            System.out.println(rst3.size());
//            Collections.sort(rst3, new Comparator<List<Integer>>() {
//                @Override
//                public int compare(List<Integer> o1, List<Integer> o2) {
//                    return o1.get(0).compareTo(o2.get(0));
//                }
//            });
//            for (List<Integer> pair: rst3){
//                System.out.println(pair);
//            }
//            System.out.println("******************");


//            String[] words4 = {"a", ""};
//            List<List<Integer>> rst4 = _solution.palindromePairs(words4);
//            for (List<Integer> pair: rst4){
//                System.out.println(pair);
//            }
//            System.out.println("******************");


//            String[] words5 = {"bb","bababab","baab","abaabaa","aaba","","bbaa","aba","baa","b"};
//            List<List<Integer>> rst5 = _solution.palindromePairs(words5);
//            System.out.println(rst5.size());
//            for (List<Integer> pair: rst5){
//                System.out.println(pair);
//            }
//            System.out.println("******************");
//        }
//    }
//}

public class PalindromePairs {
    private Map <String, Integer> record = new HashMap<String, Integer>();
    private List<List<Integer>> palinPairs = new ArrayList<List<Integer>>();
    private List<Integer> pair = new ArrayList<Integer>();

    public List<List<Integer>> palindromePairs(String[] words) {
        if (words == null || words.length <= 1){
            return null;
        }
        int wordsLen = words.length;
        for (int i = 0; i < wordsLen; ++i){
            record.put(words[i], i);
        }
        for (int i = 0; i < wordsLen; ++i){
            for (int j = 0; j <= words[i].length(); ++j){
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                pair.clear();
                createPalinPairs(str1, str2, i, false);
                if (str2.length() != 0){
                    pair.clear();
                    createPalinPairs(str2, str1, i, true);
                }
            }
        }
        return palinPairs;
    }

    private void createPalinPairs(String str1, String str2, int index, boolean reverse){
        if (isPalindrome(str1)){
            String temp = new StringBuilder(str2).reverse().toString();
            if (record.containsKey(temp) && record.get(temp) != index){
                if (!reverse){
                    pair.add(record.get(temp));
                    pair.add(index);
                } else {
                    pair.add(index);
                    pair.add(record.get(temp));
                }
                palinPairs.add(new ArrayList<Integer>(pair));
            }
        }
    }

    private boolean isPalindrome(String s) {
        int frontPtr = 0;
        int backPtr= s.length() - 1;
        if (s.isEmpty()){
            return true;
        }
        s = s.toLowerCase();
        while(frontPtr < backPtr){
            while (!Character.isLetterOrDigit(s.charAt(frontPtr)) && (frontPtr < backPtr)){
                ++frontPtr;
            }
            while (!Character.isLetterOrDigit(s.charAt(backPtr)) && (frontPtr < backPtr)){
                --backPtr;
            }
            if (s.charAt(frontPtr) != s.charAt(backPtr)){
                return false;
            }
            ++frontPtr;
            --backPtr;
        }
        return true;
    }

    static public class Test {
        static private PalindromePairs _solution = new PalindromePairs();

        static public void randomTest() {
//            String[] words1 = {"bat", "tab", "cat"};
//            List<List<Integer>> rst1 = _solution.palindromePairs(words1);
//            for (List<Integer> pair: rst1){
//                System.out.println(pair);
//            }
//            System.out.println("******************");
//
//            String[] words2 = {"lls", "s", "sssll"};
//            List<List<Integer>> rst2 = _solution.palindromePairs(words2);
//            for (List<Integer> pair: rst2){
//                System.out.println(pair);
//            }
//            System.out.println("******************");


//            String[] words3 = {"bbbbbabbabbbb","baabbaa","bbab","bbbabbaaab","abababbbbbab","abb",
//                    "baaaabbb","babbaaaba","aab","aaaab","baabbbbabbaaaba","baaab","abbbab","abaabbbabbabba",
//                    "aa","aabbbaabba","aaabbbbbaaabbbb","bbaaaaba","ababaaa","aaaaa","aaaaabbbbaaaba",
//                    "abbabbbaabbaabbb","bbaba","aaaaabbbabbbbaaaab","abbbaa","bbbabbaaa","bbbaaabaabbbaaaaabaa",
//                    "aaaabbabb","ababbababbbab","aaaaababaababbbabaaa","ba","bbbbababbbabab","baaaba",
//                    "aababbaaabbb","aabbaaabbabaaababaab","abbbb","babaabaaababb","bbbbabaaaab",
//                    "babbbbb","babaaba","aaba","abababba","a","bb","abaaab","babbabaababbabaaba",
//                    "aaaaaababbbabaaabaa","baabaaabb","b","bbaaaabbb","abaaaaabaabbbaa","ab",
//                    "bababaaaba","aabababb","ababaabbaababba","bbb","ababbaabababbbbbabb","bbbbb"
//                    ,"abbbbaabaaaabb","baba","bbaabbabaaababaabbaa","bbaabaabbabbaab","bbbaabbab",
//                    "babbbbbaaaaabaa","abbbbbbabbbabb","abaa","bbbbaababaab","abaaababa",
//                    "aaaababaaababbaaba","bbabbbabbbbbbaab","abbabbabaabbabbbba","abbbbbaabbbaaabaaaa",
//                    "bbaabababb","aaabababaabbaaaaaaab","ababbaabaaababb","abbbbabaaabbaaabbab",
//                    "aababababbabaaa","baabbaabbbaaaaaa","bbbbbbbabbabbbbbb","bbbabbabbabbabaabba",
//                    "babbbbabaaaabbabaab","baabaabaabababaaabba","bbaaaabbbbabbbaaaa","aaaaabaabaa",
//                    "bbabaaabbbabaa","baaabaaaaaab","ababbbbbbbabaaaba","abbbabaababbbbbaaa","baaaaaabab",
//                    "aabbabba","baaabbaabbbbaba","aaaaabba","babaaabbba","bbbbab","bbbbaabbaabab","baa",
//                    "baababaa","abbbbb","babbaa","abbbabbaa"};
//            String[] words3 = {"bbbbbabbabbbb", "b"};

//            System.out.println(words3[32]);
//            System.out.println(words3[44]);
//            List<List<Integer>> rst3 = _solution.palindromePairs(words3);
//            System.out.println(rst3.size());
//            Collections.sort(rst3, new Comparator<List<Integer>>() {
//                @Override
//                public int compare(List<Integer> o1, List<Integer> o2) {
//                    return o1.get(0).compareTo(o2.get(0));
//                }
//            });
//            for (List<Integer> pair: rst3){
//                System.out.println(pair);
//            }
//            System.out.println("******************");


//            String[] words4 = {"a", ""};
//            List<List<Integer>> rst4 = _solution.palindromePairs(words4);
//            for (List<Integer> pair: rst4){
//                System.out.println(pair);
//            }
//            System.out.println("******************");


//            String[] words5 = {"bb","bababab","baab","abaabaa","aaba","","bbaa","aba","baa","b"};
//            List<List<Integer>> rst5 = _solution.palindromePairs(words5);
//            System.out.println(rst5.size());
//            for (List<Integer> pair: rst5){
//                System.out.println(pair);
//            }
//            System.out.println("******************");

            String[] words6 = {"a","b","c","ab","ac","aa"};
            List<List<Integer>> rst6 = _solution.palindromePairs(words6);
            System.out.println(rst6.size());
            for (List<Integer> pair: rst6){
                System.out.println(pair);
            }
            System.out.println("******************");


        }
    }
}