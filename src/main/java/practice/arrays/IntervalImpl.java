package main.java.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

    // firstList  = [[0,2],[5,10],[13,23],[24,25]]
    // secondList = [[1,5],[8,12],[15,24],[25,26]]
    int l1 = firstList.length;
    int l2 = secondList.length;

    List<int[]> res = new ArrayList<>();

    int i = 0, j = 0;

    while (i < l1 && j < l2) {

      int[] intI = firstList[i];
      int[] intJ = secondList[j];

      int startMax = Math.max(intI[0], intJ[0]);
      int endMin = Math.min(intI[1], intJ[1]);

      if (endMin >= startMax) {
        res.add(new int[]{startMax, endMin});
      }

      if (endMin == intJ[1]) {
        j++;
      }

      if (endMin == intI[1]) {
        i++;
      }

    }
    return res.toArray(new int[res.size()][]);
  }
}
