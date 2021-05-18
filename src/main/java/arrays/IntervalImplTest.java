package main.java.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IntervalImplTest {

  private Interval interval = new IntervalImpl();

  @Test
  void merge() {
    //[[1,3],[2,6],[8,10],[15,18]]
    int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    int[][] result = interval.merge(intervals);
    assertEquals(3, result.length);
  }

  @Test
  void intervalIntersection() {

    //[[1,3],[2,6],[8,10],[15,18]]
    int[][] intervals1 = new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}};
    int[][] intervals2 = new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}};
    int[][] result = interval.intervalIntersection(intervals1, intervals2);
    assertEquals(6, result.length);
  }
}