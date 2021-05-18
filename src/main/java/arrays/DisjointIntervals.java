package main.java.arrays;

import java.util.Comparator;
import java.util.List;

public class DisjointIntervals {

  //List of List of Integers with intervals
  public int count(List<List<Integer>> lists) {

    lists.sort(Comparator.comparingInt(a -> a.get(1)));
    System.out.println(lists.get(0));
    System.out.println(lists.get(1));
    System.out.println(lists.get(2));
    System.out.println(lists.get(3));

    return -1;
  }

}