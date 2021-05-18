package test.java.arrays;

import java.util.ArrayList;
import java.util.List;
import main.java.arrays.GasStationV2;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class GasStationV2Test {

  private GasStationV2 gasStation;

  @Test
  public void startingIndex1() {

    int[] a = {1, 2, 2};
    int[] b = {2, 1, 4};

    gasStation = new GasStationV2();
    Assert.assertEquals(-1, gasStation.startingIndex(a, b, 3));

  }

  @Test
  public void startingIndex2() {

    int[] a = {1, 2};
    int[] b = {2, 1};

    gasStation = new GasStationV2();
    Assert.assertEquals(1, gasStation.startingIndex(a, b, 2));

  }

  @Test
  public void startingIndexUsingList1() {

    List<Integer> a = new ArrayList<>();
    a.add(1);
    a.add(2);
    a.add(2);

    List<Integer> b = new ArrayList<>();
    b.add(2);
    b.add(1);
    b.add(4);

    gasStation = new GasStationV2();
    Assert.assertEquals(-1, gasStation.startingIndexUsingList(a, b, 3));

  }

  @Test
  public void startingIndexUsingList2() {

    List<Integer> a = new ArrayList<>();
    a.add(1);
    a.add(2);

    List<Integer> b = new ArrayList<>();
    b.add(2);
    b.add(1);

    gasStation = new GasStationV2();
    Assert.assertEquals(1, gasStation.startingIndexUsingList(a, b, 2));

  }
}