package solutions;
import solutions.utils.Interval;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by James on 10/10/16.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals){
        List<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0)
            return result;
        //sort first to make sure every interval can be merges
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Interval ref = intervals.get(0);
        for (int i = 1; i < intervals.size(); ++i){
            Interval cur = intervals.get(i);
            //cur is before ref
//            if (cur.end < ref.start)
//                result.add(cur);
            //cur is after ref
            if (cur.start > ref.end){
                result.add(ref);
                ref = cur;
            }
            //overlap
            else{
                ref.start = Math.min(ref.start, cur.start);
                ref.end = Math.max(ref.end, cur.end);
            }
        }
        result.add(ref);
        return result;
    }
    static public class Test {
        static private MergeIntervals _solution =
                new MergeIntervals();

        static public void randomTest() {
            Interval i1 = new Interval(8, 10);
            Interval i2 = new Interval(2, 6);
            Interval i3 = new Interval(15, 18);
            Interval i4 = new Interval(1, 3);
            List<Interval> intervals = new ArrayList<Interval>();
            intervals.add(i1);
            intervals.add(i2);
            intervals.add(i3);
            intervals.add(i4);
            List <Interval> rst = _solution.merge(intervals);
        }
    }
}
