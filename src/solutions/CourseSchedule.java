package solutions;
import com.sun.tools.javac.util.Assert;
import java.util.*;

/**
 * Created by James on 7/13/16.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0){
           return false;
        }
        List<Set> adjCourses = new ArrayList<Set>();
        for (int i = 0; i < numCourses; ++i){
            adjCourses.add(new HashSet<Integer>());
        }
        for (int i = 0; i < prerequisites.length; ++i){
            adjCourses.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] preNums = new int[numCourses];
        for (int i = 0; i < numCourses; ++i){
            Set set = adjCourses.get(i);
            Iterator<Integer> it = set.iterator();
            while (it.hasNext()){
                preNums[it.next()]++;
            }
        }
        for (int i = 0; i < numCourses; ++i){
            int j = 0;
            for (; j < numCourses; ++j){
                if (preNums[j] == 0){
                    break;
                }
            }
            if (j == numCourses){
                return false;
            }
            preNums[j] = -1;
            Set set = adjCourses.get(j);
            Iterator<Integer> it = set.iterator();
            while(it.hasNext()){
                preNums[it.next()]--;
            }
        }
        return true;
    }
    static public class Test {
        static private CourseSchedule _solution = new CourseSchedule();

        static public void test(int numCourses, int[][] prerequisites, boolean ans) {
            Assert.check(ans == _solution.canFinish(numCourses, prerequisites));
        }

        static public void randomTest() {
            int[][] p1 = {{1, 0}, {1, 2}, {3, 0}};
            int n1 = 4;
            test(n1, p1, true);
        }
    }
}
