package solutions;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 5/4/16.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        if (n < 0)
            return null;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        return combineHelper(result, path, k, n, 0, 1);
    }

    private List<List<Integer>> combineHelper(List<List<Integer>> result, List<Integer> path,
                                              int k, int n, int count, int start){
        for (int i = start; i <= n+1; ++i){
            if (count == k){
                result.add(new ArrayList<Integer>(path));
                return result;
            }
            path.add(i);
            ++count;
            combineHelper(result, path, k, n, count, i+1);
            path.remove(path.size() - 1);
            --count;
        }
        return result;
    }
    static public class Test {
        static private Combinations _solution = new Combinations();

        static public void test(int n, int k, List<List<Integer>> ans) {
            assert ans == (_solution.combine(n, k));
        }

        static public void randomTest() {

        }
    }
}
