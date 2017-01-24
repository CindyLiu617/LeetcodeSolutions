package solutions;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> rst = new ArrayList<String>();
        for (int i = 1; i <= n; ++i) {
            if (i % 3 == 0 && i % 5 == 0) {
                rst.add("FizzBuzz");
            } else if (i % 5 == 0) {
                rst.add("Buzz");
            } else if (i % 3 == 0) {
                rst.add("Fizz");
            } else {
                rst.add(Integer.toString(i));
            }
        }
        return rst;
    }

    static public class Test {
        static private FizzBuzz _solution = new FizzBuzz();

        static public void randomTest() {
            List<String> rst1 = _solution.fizzBuzz(15);
            for (String str: rst1) {
                System.out.println(str);
            }
        }
    }
}
