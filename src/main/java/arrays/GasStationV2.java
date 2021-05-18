package main.java.arrays;

import java.util.ArrayList;
import java.util.List;

public class GasStationV2 {

  public int startingIndex(int[] A, int[] B, int N) {
    int startingIndex = -1;

    List<Integer> c = new ArrayList<>();
    //O(N)
    for (int i = 0; i < N; i++) {
      if (A[i] >= B[i]) {
        c.add(i);
      }
    }

    //a[i]  -  b[i] >= 0
    for (int index : c) {
      int i = 0;
      int currentIndex;
      int remainingGas = 0;
      while (i < N) {
        currentIndex = (index + i) % N;
        if (A[currentIndex] + remainingGas - B[currentIndex] < 0) {
          break;
        } else {
          remainingGas = remainingGas + A[currentIndex] - B[currentIndex];
        }
        i++;
      }

      if (i == N) {
        startingIndex = index;
        break;
      }
    }

    return startingIndex;
  }

  public int startingIndexUsingList(List<Integer> A, List<Integer> B, int N) {
    int startingIndex = -1;

    List<Integer> c = new ArrayList<>();
    //O(N)
    for (int i = 0; i < N; i++) {
      if (A.get(i) >= B.get(i)) {
        c.add(i);
      }
    }

    //a[i]  -  b[i] >= 0
    for (int index : c) {
      int i = 0;
      int currentIndex;
      int remainingGas = 0;
      while (i < N) {
        currentIndex = (index + i) % N;
        if (A.get(currentIndex) + remainingGas - B.get(currentIndex) < 0) {
          break;
        } else {
          remainingGas = remainingGas + A.get(currentIndex) - B.get(currentIndex);
        }
        i++;
      }

      if (i == N) {
        startingIndex = index;
        break;
      }
    }

    return startingIndex;
  }

}
