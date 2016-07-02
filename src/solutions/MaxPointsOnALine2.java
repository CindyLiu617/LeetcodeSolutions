package solutions;
import com.sun.tools.javac.util.Assert;
import solutions.utils.Point;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by James on 6/29/16.
 */

public class MaxPointsOnALine2 {
    /**
     * @param points an array of point
     * @return an integer
     */
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0)
            return 0;
        if (points.length == 1)
            return 1;
        int numOfPoints = points.length, rst = 1;
        final double epsilon = 0.000000001;
        TreeMap<Double, Integer> lines = new TreeMap<Double, Integer>(new Comparator<Double>() {
            @Override
            public int compare(Double d1, Double d2) {
                if (Math.abs(d1 - d2) < epsilon)
                    return 0;
                else
                    return d1 > d2 ? 1 : -1;
            }
        });
        for (int i = 0; i < numOfPoints; ++i){
            lines.clear();
            lines.put(Double.MIN_VALUE, 1);
            int overLapped = 0;
            for (int j = i+1; j < numOfPoints; ++j){
                if ((points[i].x == points[j].x) && (points[i].y == points[j].y)){
                    ++overLapped;
                    continue;
                }
                double slope;
                if (points[i].x == points[j].x){
                    slope = Double.MAX_VALUE;
                }
                else{
                    slope = (points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                }
                if (lines.containsKey(slope)){
                    lines.put(slope, lines.get(slope) + 1);
                }
                else{
                    lines.put(slope, 2);
                }
            }
            for (Integer numInOneLine: lines.values()){
                if (numInOneLine + overLapped > rst){
                    rst = numInOneLine + overLapped;
                }
            }
        }
        return rst;
    }

    static public class Test {
        static private MaxPointsOnALine2 _solution = new MaxPointsOnALine2();

        static public void test(Point[] points, int ans) {
            Assert.check(ans == _solution.maxPoints(points));
        }

        static public void randomTest() {


            Point point1 = new Point(1, 2);
            Point point2 = new Point(3, 6);
            Point point3 = new Point(0, 0);
            Point point4 = new Point(1, 3);
            Point[] points1 = {point1, point2, point3, point4};
            test(points1, 3);


            Point point11 = new Point(4, 2);
            Point point12 = new Point(3, 2);
            Point[] points2 = {point1, point2, point11, point12};
            test(points2, 3);

            Point point21 = new Point(4, 2);
            Point point22 = new Point(3, 2);
            Point point23 = new Point(1, 2);
            Point point24 = new Point(3, 6);
            Point[] points3 = {point1, point2, point21, point22, point23, point24};
            test(points3, 4);

            Point point31 = new Point (0, 0);
            Point point32 = new Point(0, 0);
            Point[] points4 = {point31, point32};
            test(points4, 2);

            Point point41 = new Point(-230, 324);
            Point point42 = new Point(-291, 141);
            Point point43 = new Point(80, 22);
            Point point44 = new Point(-28, -134);
            Point point45 = new Point(40, -23);
            Point point46 = new Point(-72, -149);
            Point point47 = new Point(0, -17);
            Point point48 = new Point(32, -32);
            Point point49 = new Point(-207, 288);
            Point point50 = new Point(7, 32);
            Point point51 = new Point(-5, 0);
            Point point52 = new Point(-161, 216);
            Point point53 = new Point(-48, -122);
            Point point54 = new Point(-3, 39);
            Point point55 = new Point(-40, -113);
            Point point56 = new Point(115, -216);
            Point point57 = new Point(-112, -464);
            Point point58 = new Point(-72, -149);
            Point point59 = new Point(-32, -104);
            Point point60 = new Point(12, 42);
            Point point61 = new Point(-22, 19);
            Point point62 = new Point(-6, -21);
            Point point63 = new Point(-48, -122);
            Point point64 = new Point(161, -288);
            Point point65 = new Point(16, 11);
            Point point66 = new Point(39, 23);
            Point point67 = new Point(39, 30);
            Point point68 = new Point(873, -111);
            Point point69 = new Point(34, -2);
            Point[] points5 = {point41, point42, point43, point44, point45, point46,point47, point48, point49, point50, point51, point52,
                    point53, point54, point55,point56, point57, point58,point59, point60, point61,point62, point63,point64, point65,point66, point67,point68, point69};
            test(points5, 9);
        }
    }
}
