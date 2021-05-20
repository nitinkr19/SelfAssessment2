package main.java.practice.arrays;

import java.util.List;
import java.util.PriorityQueue;

public class IteratorForMultipleArraysInAscendingOrder {

  private final List<List<Integer>> listOfLists;
  private final int[] indexInEachList;

  private final PriorityQueue<Integer> priorityQueue;

  public IteratorForMultipleArraysInAscendingOrder(
      List<List<Integer>> listOfLists
  ) {
    this.listOfLists = listOfLists;
    indexInEachList = new int[listOfLists.size()];
    this.priorityQueue = new PriorityQueue<>();
    preProcess();
  }

  public Integer next() {
    Integer item = priorityQueue.remove();
    postProcess(item);
    return item;
  }

  public boolean hasNext() {
    return !priorityQueue.isEmpty();
  }

  private void preProcess() {
    for (List<Integer> list : listOfLists) {
      priorityQueue.add(list.get(0));
    }
  }

  private void postProcess(Integer item) {
    for (int index = 0; index < indexInEachList.length; index++) {
      if (item.equals(listOfLists.get(index).get(indexInEachList[index]))) {
        indexInEachList[index] += 1;
        if (indexInEachList[index] < listOfLists.get(index).size()) {
          priorityQueue.add(listOfLists.get(index).get(indexInEachList[index]));
        }
        return;
      }
    }
  }

}
