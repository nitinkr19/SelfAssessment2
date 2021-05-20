package test.java.practice.arrays;

import main.java.practice.arrays.GasStation;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class GasStationTest {

  private GasStation gasStation;

  @Test
  public void gasStation1() {

    int[] a = {1, 2, 2};
    int[] b = {2, 1, 4};

    gasStation = new GasStation(a, b);
    Assert.assertEquals(-1, gasStation.callGasStationStartingPoint());

  }

}