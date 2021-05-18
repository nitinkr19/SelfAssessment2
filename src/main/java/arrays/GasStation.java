package main.java.arrays;

import java.util.Arrays;

public class GasStation {

  private final int[] a;
  private final int[] b;

  public GasStation(int[] a, int[] b) {
    this.a = a;
    this.b = b;
  }

  public int callGasStationStartingPoint() {

    int size = a.length;
    int[] remainingGas;
    boolean[] startingIndexList = new boolean[size];
    int indexWithMinGas = -1;
    int startingMinGas = -1;
//    remainingGas[0] = a[1] - b[1];
    for (int index1 = 0; index1 < size; index1++) {
      boolean canStartAtIndex1 = true;
      remainingGas = new int[size];
      for (int i = 0; i < size - 1; i++) {
        int index2 = index1 + i;
        if (index2 >= size) {
          index2 = index2 - size;
        }

        int futureGas = a[index2] - b[index2] + remainingGas[index2];
        // 0 -> 1 -> 2 -> 3
        // 1 -> 2 -> 3 -> 0
        if (futureGas < 0) {
          canStartAtIndex1 = false;
          break;
        }

        int futureIndex = index2 + 1;
        if (futureIndex >= size) {
          futureIndex = futureIndex - size;
        }
        remainingGas[futureIndex] = futureGas;
      }

      if (canStartAtIndex1) {
        startingIndexList[index1] = true;
      }
      if (canStartAtIndex1 && (a[index1] < startingMinGas || startingMinGas == -1)) {
        startingMinGas = a[index1];
        indexWithMinGas = index1;
      }

    }
    System.out.println(Arrays.toString(startingIndexList));
    return indexWithMinGas;
  }

}
