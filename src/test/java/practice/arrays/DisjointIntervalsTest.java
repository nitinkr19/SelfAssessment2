package test.java.practice.arrays;

import java.util.Arrays;
import java.util.List;
import main.java.practice.arrays.DisjointIntervals;
import org.junit.jupiter.api.Test;

class DisjointIntervalsTest {

  private DisjointIntervals disjointIntervals;

  @Test
  void count() {

    List<List<Integer>> list =
        Arrays.asList(
            Arrays.asList(1, 4),
            Arrays.asList(2, 3),
            Arrays.asList(4, 7),
            Arrays.asList(7, 9)
        );

    disjointIntervals = new DisjointIntervals();
    disjointIntervals.count(list);
  }
}