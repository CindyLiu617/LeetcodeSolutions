package solutions;

import java.util.*;

public class LetterCombination {
    public ArrayList<char[]> generateOrderedCombination(char[] array, int n) {
        ArrayList<char[]> combinations = new ArrayList<char[]>();
        HashMap<Integer, ArrayList<char[]>> fillRecord =
                new HashMap<Integer, ArrayList<char[]>>();
        if (n > array.length) {
            return combinations;
        }

        for (int i = 0; i < array.length; ++i) {
            // j == 0
            char[] initiate = new char[n];
            initiate[0] = array[i];
            combinations.add(initiate);
            fillRecord.put(0, combinations);
            for (int j = 1; j < n; ++j) {
                //fill empty position
                ArrayList<char[]> prev = fillRecord.get(j - 1);
                if (!fillRecord.containsKey(j)) {
                    fillRecord.put(j, new ArrayList<char[]>());
                }
                ArrayList<char[]> curr = fillRecord.get(j);
                final int size = prev.size();
                for (int k = 0; k < size; ++k) {
                    char[] copy = Arrays.copyOf(prev.get(k), prev.get(k).length);
                    if (prev.get(k)[j] == 0) {
                        copy[j] = array[i];
                    }
                    curr.add(copy);
                    fillRecord.put(j, curr);
                }
            }
        }
        return fillRecord.get(n - 1);
    }

    //@SuppressWarning("unchecked") tells compiler (List<char[]>) queue cast
    // is safe
    @SuppressWarnings("unchecked")
    public List<char[]> generateUnorderedCombination(char[] array, int n) {
        Queue<char[]> queue = new LinkedList<char[]>();
        if (array == null || array.length == 0 || n > array.length) {
            return (List<char[]>) queue;
        }
        queue.add(new char[1]);
        for (int i = 1; i <= n; ++i) {
            int size = queue.size();
            for (int k = 0; k < size; ++k) {
                char[] popItem = queue.poll();
                for (int j = 0; j < array.length; ++j) {
                    char[] newItem = new char[i];
                    System.arraycopy(popItem, 0, newItem, 0, i - 1);
                    newItem[i - 1] = array[j];
                    queue.add(newItem);
                }
            }
        }
        return (List<char[]>) queue;
    }

    static public class Test {
        static private LetterCombination _solution = new LetterCombination();

        static public void randomTest() {
            char[] A = {'a', 'b', 'c', 'd'};
            ArrayList<char[]> rst1 = _solution.generateOrderedCombination(A, 4);
            for (int i = 0; i < rst1.size(); ++i) {
                for (int j = 0; j < 4; ++j) {
                    System.out.print(rst1.get(i)[j]);
                }
                System.out.println(">>>>>>");
            }
        }
    }
}
