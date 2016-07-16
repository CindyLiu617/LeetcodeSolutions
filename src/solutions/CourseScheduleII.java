package solutions;
import java.util.*;

/**
 * Created by James on 7/15/16.
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        if (prerequisites == null || prerequisites.length == 0){
//            return new int[1];
//        }
        int[] sorted = new int[numCourses];
        int idx = 0;
        List<Set> adjCourses = new ArrayList<Set>();
        Queue<Integer> q = new LinkedList<Integer>();
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
            if (preNums[i] == 0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int cur = q.poll();
            sorted[idx] = cur;
            ++idx;
            Set set = adjCourses.get(cur);
            Iterator<Integer> it = set.iterator();
            while(it.hasNext()){
                int next = it.next();
                preNums[next]--;
                if (preNums[next] == 0){
                    q.add(next);
                }
            }
        }
        if (idx == numCourses)
            return sorted;
        return new int[0];
    }
    static public class Test {
        static private CourseScheduleII _solution = new CourseScheduleII();

        static public void randomTest() {
//            int[][] p1 = {{1, 0}, {1, 2}, {3, 0}};
//            int n1 = 4;
//            int[] rst1 = _solution.findOrder(n1, p1);
//            for (int i = 0; i < n1; ++i){
//                System.out.println(rst1[i]);
//            }

//            int[][] p2 = {};
//            int n2 = 1;
//            int[] rst2 = _solution.findOrder(n2, p2);
//            for (int i = 0; i < n2; ++i){
//                System.out.println(rst2[i]);
//            }

            int[][] p3 = {};
            int n3 = 2;
            int[] rst3 = _solution.findOrder(n3, p3);
            for (int i = 0; i < n3; ++i){
                System.out.println(rst3[i]);
            }
        }
    }
}
