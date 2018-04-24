package temp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class
 *time: O(nlogn) 因为有个排序
 * space: O(n)
 * @author Yi Qin
 * @date 2018-04-24
 */
public class MergeIntervals56 {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1) return intervals;
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval i: intervals){
            if(i.start <= end){
                end=Math.max(end, i.end);
            }else{
                res.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}
class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }