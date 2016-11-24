package solutions;

import java.util.ArrayList;
import java.util.HashMap;

public class LetterCombinationOrder {
    public ArrayList<char[]> generateCombination(char[] array, int n) {
        ArrayList<char[]> combinations = new ArrayList<char[]>();
        ArrayList<char[]> rst = new ArrayList<char[]>();
        HashMap<Integer, ArrayList<char[]>> fillRecord =
                new HashMap<Integer, ArrayList<char[]>>();
        if (n > array.length) {
            return combinations;
        }
        int fillNum = 1;
        for (int i = 0; i < array.length; ++i) {
            char[] initiate = new char[n];
            initiate[0] = array[i];
            combinations.add(initiate);
            fillRecord.put(0, combinations);
            for (int j = 1; j < n; ++j) {
                //fill empty position
                ArrayList<char[]> prev = fillRecord.get(j - 1);
                ArrayList<char[]> put;
                if (fillRecord.get(j) != null) {
                    put = fillRecord.get(j);
                } else {
                    put = new ArrayList<char[]>();
                }
                int size = prev.size();
                for (int k = 0; k < size; ++k) {
                    char[] copy = _copyArray(prev.get(k));
                    if (prev.get(k)[j] == 0) {
                        copy[j] = array[i];
                    }
                    if (j == n - 1) {
                        rst.add(copy);
                    } else {
                        put.add(copy);
                        fillRecord.put(fillNum, put);
                        ++fillNum;
                    }
                }
            }
        }
        return rst;
    }

    private char[] _copyArray(char[] array) {
        char[] rst = new char[array.length];
        for (int i = 0; i < array.length; ++i) {
            rst[i] = array[i];
        }
        return rst;
    }

    static public class Test {
        static private Playground _solution = new Playground();

        static public void randomTest() {
            char[] A = {'a', 'b', 'c', 'd'};
            ArrayList<char[]> rst1 = _solution.generateCombination(A, 4);
            for (int i = 0; i < rst1.size(); ++i) {
                for (int j = 0; j < 4; ++j) {
                    System.out.print(rst1.get(i)[j]);
                }
                System.out.println(">>>>>>");
            }
        }
    }
}
