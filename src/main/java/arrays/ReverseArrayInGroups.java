package main.java.arrays;

import java.util.List;

public class ReverseArrayInGroups {

  private final List<Integer> list;
  private final int groupSize;

  public ReverseArrayInGroups(List<Integer> list, int groupSize) {
    this.list = list;
    this.groupSize = groupSize;
  }

  public void reverseInGroups() {
    for (int index = 0; index < list.size(); index = index + groupSize) {
      reverseSubArray(
          list,
          index,
          index + groupSize > list.size() ? list.size() - index : groupSize
      );
    }
  }

  public List<Integer> list() {
    return list;
  }

  private void reverseSubArray(List<Integer> list, int startIndex, int groupSize) {
    int temp;
    for (int index = 0; index < groupSize / 2; index++) {
      temp = list.get(startIndex + index);
      list.set(startIndex + index, list.get(startIndex + groupSize - index - 1));
      list.set(startIndex + groupSize - index - 1, temp);
    }
  }
}
