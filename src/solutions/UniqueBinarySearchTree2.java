package solutions;

public class UniqueBinarySearchTree2 {
    public int numTrees(int n) {
        if(n < 0) {
            return 0;
        }
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; ++i){
            for(int j = 0; j < i; ++j){
                count[i] = count[i] + count[j] * count[i - j - 1];
            }
        }
        return count[n];
    }

    static public class Test {
        static private UniqueBinarySearchTree2 _solution = new
                UniqueBinarySearchTree2();

        static public void test(int A, int ans) {
            assert ans == _solution.numTrees(A);
        }

        static public void randomTest() {
            test(3, 5);
            test(1, 1);
        }
    }
}
