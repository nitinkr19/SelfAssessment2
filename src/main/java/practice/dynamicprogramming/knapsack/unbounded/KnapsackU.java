package main.java.practice.dynamicprogramming.knapsack.unbounded;

public class KnapsackU implements IKnapsackU {

  @Override
  public int rodCutting(int[] len, int[] price, int rodLength, int n) {

    int[][] dp = new int[n + 1][rodLength + 1];

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < rodLength + 1; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {

      for (int j = 1; j < rodLength + 1; j++) {

        if (len[i - 1] <= j) {
          dp[i][j] = Math.max(
              price[i - 1] + dp[i][j - len[i - 1]],
              dp[i - 1][j]
          );
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[n][rodLength];
  }

  @Override
  public int coinChangeMaxWays(int[] coin, int sum, int n) {

    int[][] dp = new int[n + 1][sum + 1];

    for (int j = 0; j < sum + 1; j++) {
      dp[0][j] = 0;
    }

    for (int i = 0; i < n + 1; i++) {
      dp[i][0] = 1;
    }

    for (int i = 1; i < n + 1; i++) {

      for (int j = 1; j < sum + 1; j++) {

        if (coin[i - 1] <= j) {
          dp[i][j] = dp[i][j - coin[i - 1]] + dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[n][sum];
  }

  @Override
  public int coinChangeMinCoins(int[] coin, int sum, int n) {
    int[][] dp = new int[n + 1][sum + 1];

    //Initializing 1st row and 1st col
    for (int j = 0; j < sum + 1; j++) {
      dp[0][j] = Integer.MAX_VALUE - 1;
    }

    for (int i = 1; i < n + 1; i++) {
      dp[i][0] = 0;
    }

    //Filling 2nd row
    for (int j = 1; j < sum + 1; j++) {
      if (j % coin[0] == 0) {
        dp[1][j] = j / coin[0];
      } else {
        dp[1][j] = Integer.MAX_VALUE - 1;
      }
    }

    for (int i = 2; i < n + 1; i++) {

      for (int j = 1; j < sum + 1; j++) {

        if (coin[i - 1] <= j) {
          dp[i][j] = Math.min(
              1 + dp[i][j - coin[i - 1]],
              dp[i - 1][j]
          );
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[n][sum];
  }
}
