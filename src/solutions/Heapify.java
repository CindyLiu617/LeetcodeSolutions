package solutions;

/**
 * Created by James on 6/13/16.
 */
public class Heapify {
    public void heapify(int[] A) {
        // write your code here
        if (A == null || A.length == 0)
            return;
        for (int i = 0; i < A.length; ++i)
            helper(A, i);
    }

    private void helper(int[] targetArray, int index) {
        while (index < targetArray.length) {
            int smallest = index;
            if (index * 2 + 1 < targetArray.length && targetArray[index * 2 + 1] < targetArray[smallest]) {
                smallest = index * 2 + 1;
            }
            if (index * 2 + 2 < targetArray.length && targetArray[index * 2 + 2] < targetArray[smallest]) {
                smallest = index * 2 + 2;
            }
            if (smallest == index) {
                break;
            }
            //swap
            int temp = targetArray[smallest];
            targetArray[smallest] = targetArray[index];
            targetArray[index] = temp;

            index = smallest;
        }
    }
    static public class Test {
        static private Heapify _solution = new Heapify();

        static public void randomTest() {
            int[] A1 = {3, 2, 1, 5,4};
            _solution.heapify(A1);
            for (int i = 0; i < A1.length; ++i){
                System.out.println(A1[i]);
            }
        }
    }
}
