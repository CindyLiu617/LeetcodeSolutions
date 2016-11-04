package solutions;

import java.util.ArrayList;

public class GenerateParentheses {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> rst = new ArrayList<String>();
        if (n <= 0){
            return rst;
        }
        backTracking("", rst, n, n);
        return rst;
    }
    private void backTracking (String seed, ArrayList<String> rst,
                               int left, int right){
        //ATTENTION!! left must less than right, otherwise the output is not
        // legal eg. ")()("
        if (left > right || left < 0 || right < 0){
            return;
        }
        if (left == 0 && right == 0){
            rst.add(seed);
            return;
        }
        backTracking(seed + '(', rst, left - 1, right);
        backTracking(seed + ')', rst, left, right - 1);
    }

    static public class Test {
            static private GenerateParentheses _solution = new GenerateParentheses();

            static public void randomTest() {
                ArrayList<String> rst = _solution.generateParenthesis(2);

                for (int i = 0; i < rst.size(); ++i){
                    System.out.println(rst.get(i));
                }
            }
        }
}
