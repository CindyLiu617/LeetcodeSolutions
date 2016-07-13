package solutions;
import com.sun.tools.javac.util.Assert;
import java.util.Stack;

/**
 * Created by James on 7/12/16.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int rst = 0, strLen = s.length(), start = -1;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < strLen; ++i){
            if (s.charAt(i)=='(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        rst = Math.max(rst, i-start);
                    }
                    else {
                        rst = Math.max(rst, i-stack.peek());
                    }
                }
            }
        }
        return rst;
    }
    static public class Test {
        static private LongestValidParentheses _solution = new LongestValidParentheses();

        static public void test(String s, int ans) {
            Assert.check(ans == _solution.longestValidParentheses(s));
        }

        static public void randomTest() {
//            test("(()", 2);
            test(")()())", 4);
        }
    }
}
