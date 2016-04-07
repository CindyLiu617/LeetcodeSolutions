package solutions;

import com.sun.tools.javac.util.Assert;
import solutions.utils.Interval;
import java.util.Arrays;
/**
 * Created by James on 4/6/16.
 */
public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;

        final int len = intervals.length;
        int[] start = new int[len];
        int[] end = new int[len];
        for(int i = 0; i < len; ++i){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int roomCnt = 0;
        int maxRoomCnt = 0;
        int ptrStart = 0;
        int ptrEnd = 0;
        while (ptrStart < len && ptrEnd < len){
            if(start[ptrStart] < end[ptrEnd]){
                roomCnt = roomCnt + 1;
                ++ptrStart;
            } else{
                roomCnt = roomCnt - 1;
                ++ptrEnd;
            }
            maxRoomCnt = Math.max(maxRoomCnt, roomCnt);
        }
        return maxRoomCnt;
    }

    static public class Test {
        static private MeetingRoomsII _solution = new MeetingRoomsII();

        static public void test(Interval[] intervals, int ans) {
            Assert.check(ans == (_solution.minMeetingRooms(intervals)));
        }

        static public void randomTest() {
//            Interval interval1 = new Interval(4, 9);
//            Interval interval2 = new Interval(9, 10);
//            Interval interval3 = new Interval(4, 18);
//            Interval[] intervals = {interval1, interval2, interval3};
//            test(intervals, 2);
//
//            Interval interval11 = new Interval(4, 9);
//            Interval interval21 = new Interval(10, 12);
//            Interval[] intervals2 = {interval11, interval21};
//            test(intervals2, 1);
//
//            Interval interval31 = new Interval(4, 9);
//            Interval interval32 = new Interval(3, 18);
//            Interval[] intervals3 = {interval31, interval32};
//            test(intervals3, 2);
//
//            Interval interval41 = new Interval(4, 9);
//            Interval interval42 = new Interval(3, 5);
//            Interval[] intervals4 = {interval41, interval42};
//            test(intervals4, 2);
//
//            Interval interval5 = new Interval(4, 9);
//            Interval[] intervals5 = {interval5};
//            test(intervals5, 1);

            Interval interval6 = new Interval(4, 9);
            Interval interval61 = new Interval( 10,11);
            Interval interval62 = new Interval(8, 11);
            Interval[] intervals6 = {interval6, interval61, interval62};
            test(intervals6, 2);
        }
    }
}