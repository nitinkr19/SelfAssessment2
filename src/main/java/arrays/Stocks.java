package main.java.arrays;

public class Stocks {

  public int maxProfit(int[] prices) {

    int max = Integer.MIN_VALUE;
    int minPrice = Integer.MAX_VALUE;

    for (int i = 1; i < prices.length; i++) {
      minPrice = Math.min(prices[i - 1], minPrice);
      max = Math.max(max, prices[i] - minPrice);
    }

    return max;
  }

  public int maxProfitWithMultipleTransactions(int[] prices) {

    int minPrice = Integer.MAX_VALUE;
    int result = 0;

    for (int i = 1; i < prices.length; i++) {
      minPrice = Math.min(prices[i - 1], minPrice);

      if (prices[i] > prices[i - 1]) {
        result = result + (prices[i] - prices[i - 1]);
      } else {
        minPrice = prices[i];
      }

    }

    return result;
  }

  //not working yet
  public int maxProfitWithKTransactions(int[] prices, int k) {

    int n = prices.length;
    int[][] dp = new int[k + 1][n];

    for (int i = 1; i < k + 1; i++) {
      int maxDiff = dp[i - 1][0] - prices[0];
      for (int j = 1; j < n; j++) {
        maxDiff = Math.max(maxDiff, dp[i - 1][j - 1] - prices[j - 1]);
        dp[i][j] = Math.max(prices[j] - maxDiff, dp[i][j - 1]);
      }
    }

    return dp[k][n - 1];
  }

}
