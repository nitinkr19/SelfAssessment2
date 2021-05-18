package test.java.dynamicprogramming.knapsack.unbounded;

import static org.junit.jupiter.api.Assertions.assertEquals;

import main.java.dynamicprogramming.knapsack.unbounded.IKnapsackU;
import main.java.dynamicprogramming.knapsack.unbounded.KnapsackU;
import org.junit.jupiter.api.Test;

class KnapsackUTest {

  private final IKnapsackU knapsackU = new KnapsackU();

  //DP Matrix Limits
  int n = 3;
  int W = 5;

  int[] wt = new int[]{1, 2, 3};
  int[] val = new int[]{1, 3, 5};
  int sum = 11;
  int[] arr = new int[]{2, 3, 7, 8, 10};

  @Test
  void rodCutting() {
    assertEquals(8, knapsackU.rodCutting(wt, val, W, n));
  }

  @Test
  void coinChangeMaxWays() {
    int[] coin = new int[]{1, 2, 3, 5};
    sum = 5;
    assertEquals(5, knapsackU.coinChangeMaxWays(coin, sum, n));
  }

  @Test
  void coinChangeMinCoins() {
    int[] coin = new int[]{1, 2, 3, 5};
    sum = 5;
    n = coin.length;
    assertEquals(1, knapsackU.coinChangeMinCoins(coin, sum, n));
  }
}