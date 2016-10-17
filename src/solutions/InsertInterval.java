package solutions;

import solutions.utils.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 10/11/16.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null || intervals == null)
            return null;
        List<Interval> results = new ArrayList<Interval>();
        int pos = 0;

        for (Interval interval: intervals){
            //newInterval after interval
            if (interval.end < newInterval.start){
                results.add(interval);
                ++pos;
            }
            //newInterval before interval
            else if (interval.start > newInterval.end){
                results.add(interval);
            }
            //overlap
            else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        //add newInterval at pos in result list
        results.add(pos, newInterval);
        return results;
    }
    static public class Test {
        static private InsertInterval _solution =
                new InsertInterval();

        static public void randomTest() {
            Interval i1 = new Interval(1, 3);
            Interval i2 = new Interval(6, 9);
            Interval i3 = new Interval(2, 5);

            List<Interval> intervals = new ArrayList<Interval>();
            intervals.add(i1);
            intervals.add(i2);

            List <Interval> rst = _solution.insert(intervals, i3);
        }
    }
}
