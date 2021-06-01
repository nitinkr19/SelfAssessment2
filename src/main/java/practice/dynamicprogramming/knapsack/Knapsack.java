package main.java.practice.dynamicprogramming.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knapsack implements IKnapsack {

  @Override
  public int maxProfitRecursive(int[] wt, int[] val, int W, int n) {
    return maxProfitRecursion(wt, val, W, n);
  }

  @Override
  public int maxProfitDP(int[] wt, int[] val, int W, int n) {

    int[][] dp = new int[n + 1][W + 1];

    for (int i = 0; i < n + 1; i++) {

      for (int j = 0; j < W + 1; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {

      for (int j = 1; j < W + 1; j++) {

        if (wt[i - 1] <= j) {
          dp[i][j] = Math.max(
              val[i - 1] + dp[i - 1][j - wt[i - 1]],
              dp[i - 1][j]
          );
        } else {
          dp[i][j] = dp[i - 1][j];
        }

      }
    }

    return dp[n][W];
  }

  private int maxProfitRecursion(int[] wt, int[] val, int W, int n) {

    //DP Initialization
    if (n == 0 || W == 0) {
      return 0;
    }

    if (wt[n - 1] <= W) {

      return Math.max(
          val[n - 1] + maxProfitRecursion(wt, val, W - wt[n - 1], n - 1),
          maxProfitRecursion(wt, val, W, n - 1)
      );
    } else {

      return maxProfitRecursion(wt, val, W, n - 1);
    }

  }

  @Override
  public boolean subsetSumDP(int[] arr, int sum, int n) {

    boolean[][] dp = subsetDPPopulate(arr, sum, n);

    return dp[n][sum];

  }

  private boolean[][] subsetDPPopulate(int[] arr, int sum, int n) {
    boolean[][] dp = new boolean[n + 1][sum + 1];

    for (int j = 0; j < sum + 1; j++) {
      dp[0][j] = false;
    }
    for (int i = 0; i < n + 1; i++) {
      dp[i][0] = true;
    }

    for (int i = 1; i < n + 1; i++) {

      for (int j = 1; j < sum + 1; j++) {

        if (arr[i - 1] <= j) {
          dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j];
        }

      }
    }
    return dp;
  }

  @Override
  public boolean equalSumPartition(int[] arr, int n) {

    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];
    }

    if (sum % 2 != 0) {
      return false;
    }

    return subsetSumDP(arr, sum / 2, n);
  }

  @Override
  public int countOfSubsetsSum(int[] arr, int sum, int n) {
    int[][] dp = new int[n + 1][sum + 1];

    for (int j = 0; j < sum + 1; j++) {
      dp[0][j] = 0;
    }
    for (int i = 0; i < n + 1; i++) {
      dp[i][0] = 1;
    }

    for (int i = 1; i < n + 1; i++) {

      for (int j = 1; j < sum + 1; j++) {

        if (arr[i - 1] <= j) {
          dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j];
        }

      }
    }

    return dp[n][sum];
  }

  @Override
  public int minimumSubsetSumDifference(int[] arr, int n) {

    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];
    }

    boolean[][] dp = subsetDPPopulate(arr, sum, n);

    for (int i = sum / 2; i >= 0; i--) {
      if (dp[n][i]) {
        return sum - (2 * i);
      }
    }
    return 0;
  }

  @Override
  public int countOfSubsetsWithDifference(int[] arr, int diff, int n) {

    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];
    }

    int requiredSum = (diff + sum) / 2;
    return countOfSubsetsSum(arr, requiredSum, n);
  }

  @Override
  public int targetSumWithNegativeAndPositives(int[] arr, int targetSum, int n) {

    return countOfSubsetsWithDifference(arr, targetSum, n);
  }

  static int count = 0;
  static int[][] dp;

  public long findAll(List<Integer> priceOfJeans, List<Integer> priceOfShoes, List<Integer> priceOfSkirts, List<Integer> priceOfTops, int dollars) {

    dp = new int[4][dollars+1];
    for(int i = 0 ; i < 4 ; i++){
      Arrays.fill(dp[i], -1);
    }

    List<List<Integer>> allPrices = new ArrayList();
    allPrices.add(priceOfJeans);
    allPrices.add(priceOfShoes);
    allPrices.add(priceOfSkirts);
    allPrices.add(priceOfTops);

    findAllPossibleWays(allPrices, dollars, 0, 0);
    return count;
  }

  private void findAllPossibleWays(
      List<List<Integer>> prices,
      int totalPrice,
      int itemIndex,
      int currSum
  ) {

    if(currSum > totalPrice) {
      return;
    }

    if(itemIndex == prices.size()) {
      count++;
      return;
    }

    if(dp[itemIndex][totalPrice-currSum] != -1){
      count++;
      return;
    }

    for(int priceOfEachOption : prices.get(itemIndex)) {
      currSum += priceOfEachOption;
      findAllPossibleWays(prices, totalPrice, itemIndex + 1, currSum);
      if(totalPrice - currSum >= 0) {
        dp[itemIndex][totalPrice-currSum] = count;
      }
      currSum -= priceOfEachOption;
    }

  }
}
