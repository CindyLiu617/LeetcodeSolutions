package solutions;

import solutions.utils.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by James on 6/1/16.
 */
public class NumberOfAirplanesIntheSky {
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        int cnt = 0;
        if (airplanes == null || airplanes.size() == 0)
            return cnt;
        int totalNum = airplanes.size(), ptr = 0, tPtr = 0, lPtr = 0, max = 0;
        int[] takeOff = new int[totalNum];
        int[] land = new int[totalNum];
        for (Interval airplane: airplanes){
            takeOff[ptr] = airplane.start;
            land[ptr] = airplane.end;
            ++ptr;
        }
        Arrays.sort(takeOff);
        Arrays.sort(land);
        while (tPtr < totalNum && lPtr < totalNum){
            if (takeOff[tPtr] < land[lPtr]){
                ++cnt;
                ++tPtr;
            } else{
                --cnt;
                ++lPtr;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
    static public class Test {
        static private NumberOfAirplanesIntheSky _solution = new NumberOfAirplanesIntheSky();

        static public void test(List<Interval> airplanes, int ans) {
            assert ans == (_solution.countOfAirplanes(airplanes));
        }

        static public void randomTest() {
//            List<Interval> airplanes1 = new ArrayList<Interval>();
//            Interval i1 = new Interval(1, 10);
//            Interval i2 = new Interval(2, 3);
//            Interval i3 = new Interval(5, 8);
//            Interval i4 = new Interval(4, 7);
//            airplanes1.add(i1);
//            airplanes1.add(i2);
//            airplanes1.add(i3);
//            airplanes1.add(i4);
//            test(airplanes1, 3);

            List<Interval> airplanes2 = new ArrayList<Interval>();
            Interval i12 = new Interval(10, 14);
            Interval i22 = new Interval(10, 15);
            Interval i32 = new Interval(10, 16);
            Interval i42 = new Interval(1, 10);
            Interval i52 = new Interval(2, 10);
            Interval i62 = new Interval(3, 10);
            Interval i72 = new Interval(4, 10);
            airplanes2.add(i12);
            airplanes2.add(i22);
            airplanes2.add(i32);
            airplanes2.add(i42);
            airplanes2.add(i52);
            airplanes2.add(i62);
            airplanes2.add(i72);
            test(airplanes2, 4);
        }
    }
}
