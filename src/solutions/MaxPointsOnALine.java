package solutions;

import com.sun.tools.javac.util.Assert;
import solutions.utils.Point;

import java.util.HashMap;

/**
 * Created by James on 4/2/16.
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0)
            return 0;
        int maxPoints = 1, numOfOverLappedPoints;
        double slope = 0.0;
        HashMap<Double, Integer> myHash = new HashMap<Double, Integer>();
        for (int i = 0; i < points.length; ++i){
            myHash.clear();
            myHash.put((double)Integer.MIN_VALUE, 1);
            numOfOverLappedPoints = 0;
            for (int j = 0; j < points.length; ++j){
                if (i == j)
                    continue;
                if (points[i].x == points[j].x && points[i].y == points[j].y){
                    ++numOfOverLappedPoints;
                    continue;
                }
                if (points[i].x == points[j].x)
                    slope = (double) Integer.MAX_VALUE;
                else
                    slope = (double)(points[j].y - points[i].y) / (double)(points[i].x - points[j].x);
                if (myHash.containsKey(slope))
                    myHash.put(slope, myHash.get(slope) + 1);
                else
                    myHash.put(slope, 2);
            }
            for (int pointsNum : myHash.values()){
                if (pointsNum + numOfOverLappedPoints > maxPoints)
                    maxPoints = pointsNum + numOfOverLappedPoints;
            }
        }
        return maxPoints;
    }

    static public class Test {
        static private MaxPointsOnALine _solution = new MaxPointsOnALine();

        static public void test(Point[] points, int ans) {
            Assert.check(ans == _solution.maxPoints(points));
        }

        static public void randomTest() {
            Point point1 = new Point(0, 0);
            Point point2 = new Point(1, 1);
//            Point point3 = new Point(2, 1);
//            Point point4 = new Point(0, 6);
//            Point point5 = new Point(0, 8);
//            Point[] points1 = {point1, point2, point3, point4, point5};
//            test(points1, 3);

            Point point11 = new Point(1,-1);
            Point[] points2 = {point1, point2, point11};
            test(points2, 2);
        }
    }
}
