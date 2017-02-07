package solutions;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    //Bit manipulation
    public List<String> readBinaryWatch (int num) {
        List<String> rst = new ArrayList<String>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == num) {
                    rst.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return rst;
    }

    static public class Test {
        static private BinaryWatch _solution = new BinaryWatch();

        static public void randomTest() {
            List<String> rst = _solution. readBinaryWatch(1);

            for (int i = 0; i < rst.size(); ++i) {
                System.out.println(rst.get(i));
            }
        }
    }
}
