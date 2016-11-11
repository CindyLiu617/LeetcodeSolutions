package solutions;

import java.util.ArrayList;
import java.util.List;

public class Combinations2 {
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (n <= 0 || k <= 0 || n < k) {
            return rst;
        }
        List<Integer> combination = new ArrayList<Integer>();
        helper(rst, combination, n, k, 1);
        return rst;
    }

    private void helper(List<List<Integer>> rst, List<Integer> combination,
                        int num, int comLen, int ptr) {
        if (combination.size() == comLen) {
            rst.add(new ArrayList<Integer>(combination));
            return;
        }
        for (int i = ptr; i <= num; ++i) {
            combination.add(i);
            helper(rst, combination, num, comLen, i + 1);
            combination.remove(combination.size() - 1);
        }
    }

    static public class Test {
        static private Combinations2 _solution = new Combinations2();

        static public void randomTest() {
            List<List<Integer>> rst = _solution.combine(4, 2);
            for (int i = 0; i < rst.size(); ++i) {
                for (int j = 0; j < rst.get(i).size(); ++j) {
                    System.out.print(rst.get(i).get(j));
                }
                System.out.println(">>>>>>>>");
            }
        }
    }
}
