package solutions;

public class JumpGame2 {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        if (A == null || A.length == 0) {
            return true;
        }
        int farthestDist = A[0];
        for (int i = 0; i < A.length; ++i) {
        //attention i < farthesDist
            if (A[i] + i > farthestDist && i < farthestDist) {
                farthestDist = A[i] + i;
            }
        }
        return farthestDist >= A.length - 1;
    }

    static public class Test {
        static private JumpGame2 _solution = new JumpGame2();

        static public void randomTest() {
            int[] A = {2, 3, 1, 1, 4};
            System.out.println(_solution.canJump(A));

            int[] B = {3, 2, 1, 0, 4};
            System.out.println(_solution.canJump(B));
        }
    }
}
