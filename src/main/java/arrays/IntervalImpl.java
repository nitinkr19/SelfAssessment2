package main.java.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntervalImpl implements Interval {

  @Override
  public int[][] merge(int[][] intervals) {

    if (intervals.length <= 1) {
      return intervals;
    }

    //sort
    Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

    List<int[]> res = new ArrayList<>();

    int[] uInterval = intervals[0];
    res.add(uInterval);
    for (int[] interval : intervals) {

      if (uInterval[1] >= interval[0]) {
        uInterval[1] = Math.max(uInterval[1], interval[1]);
      } else {
        res.add(interval);
        uInterval = interval;
      }

    }

    return res.toArray(new int[res.size()][]);
  }

  @Override
  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

    // firstList = [[0,2],[5,10],[13,23],[24,25]]
    // secondList = [[1,5],[8,12],[15,24],[25,26]]
    int l1 = firstList.length;
    int l2 = secondList.length;

    int[][] intervals =
        Stream.concat(
            Arrays.stream(firstList),
            Arrays.stream(secondList)
        ).toArray(int[][]::new);

    Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
    List<int[]> res = new ArrayList<>();
    
    int[] uInterval = intervals[0];
    boolean flag = true;

    for (int[] interval : intervals) {

      if(flag){
        flag = false;
        continue;
      }

      if (uInterval[1] >= interval[0]) {
        res.add(
            new int[]{
                Math.max(interval[0], uInterval[0]),
                Math.min(interval[1], uInterval[1])
            }
        );
      }

      uInterval = interval;

    }

    return res.toArray(new int[res.size()][]);
  }
}
