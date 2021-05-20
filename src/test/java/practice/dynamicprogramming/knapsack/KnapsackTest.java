package test.java.practice.dynamicprogramming.knapsack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import main.java.practice.dynamicprogramming.knapsack.IKnapsack;
import main.java.practice.dynamicprogramming.knapsack.Knapsack;
import org.junit.jupiter.api.Test;

class KnapsackTest {

  private final IKnapsack knapsack = new Knapsack();

  //DP Matrix Limits
  int n = 5;
  int W = 10;

  int[] wt = new int[]{1, 2, 4, 5, 7};
  int[] val = new int[]{1, 3, 5, 6, 8};
  int sum = 11;
  int[] arr = new int[]{2, 3, 7, 8, 10};

  @Test
  void maxProfitRecursive() {
    assertEquals(12, knapsack.maxProfitRecursive(wt, val, W, n));
  }

  @Test
  void maxProfitDP() {
    assertEquals(12, knapsack.maxProfitDP(wt, val, W, n));
  }

  @Test
  void subsetSumDP() {
    assertTrue(knapsack.subsetSumDP(arr, sum, n));
    sum = 6;
    assertFalse(knapsack.subsetSumDP(arr, sum, n));
  }

  @Test
  void equalSumPartition() {
    assertTrue(knapsack.equalSumPartition(arr, n));
    arr = new int[]{2, 3, 7, 8, 1};
    assertFalse(knapsack.equalSumPartition(arr, n));
  }

  @Test
  void countOfSubsetsSum() {
    sum = 10;
    assertEquals(3, knapsack.countOfSubsetsSum(arr, sum, n));
  }

  @Test
  void minimumSubsetSumDifference() {
    assertEquals(0, knapsack.minimumSubsetSumDifference(arr, n));
  }

  @Test
  void countOfSubsetsWithDifference() {
    int diff = 6;
    assertEquals(2, knapsack.countOfSubsetsWithDifference(arr, diff, n));
    arr = new int[]{1, 1, 2, 3};
    diff = 1;
    n = arr.length;
    assertEquals(3, knapsack.countOfSubsetsWithDifference(arr, diff, n));
  }

  @Test
  void targetSumWithNegativeAndPositives() {
    int sum = 1;
    arr = new int[]{1, 1, 2, 3};
    n = arr.length;
    assertEquals(3, knapsack.targetSumWithNegativeAndPositives(arr, sum, n));
    arr = new int[]{1, 1, 1, 1, 1};
    sum = 3;
    n = arr.length;
    assertEquals(5, knapsack.countOfSubsetsWithDifference(arr, sum, n));
  }
}