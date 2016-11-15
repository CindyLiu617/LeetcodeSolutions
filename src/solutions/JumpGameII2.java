package solutions;

public class JumpGameII2 {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int left = 0, right = 0, rst = 0;
        while (right < A.length - 1) {
            ++rst;
            int farthest = right;
            for (int i = left; i <= right; ++i) {
                if (A[i] + i > farthest) {
                    farthest = A[i] + i;
                }
            }
            //the range of next jump
            left = right + 1;
            right = farthest;
        }
        return rst;
    }

    static public class Test {
        static private JumpGameII2 _solution = new JumpGameII2();

        static public void randomTest() {
//            int[] A = {2, 3, 1, 1, 4};
//            System.out.println(_solution.jump(A));

            int[] B = {13, 52, 42, 21, 58};
            System.out.println(_solution.jump(B));
        }
    }
}
