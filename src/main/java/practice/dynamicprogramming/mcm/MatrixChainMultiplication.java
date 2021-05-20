package main.java.practice.dynamicprogramming.mcm;

import java.util.Arrays;

public class MatrixChainMultiplication implements MCM {

  private int[][] dp;

  @Override
  public int minCostToMultiply(int[] arr) {
    int n = arr.length;
    populateDPDefaultValues(n, -1);

    return minCostToMultiply(arr, 1, n - 1);
  }

  private void populateDPDefaultValues(int n, int defaultValue) {
    dp = new int[n][n];

    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], defaultValue);
    }
  }

  @Override
  public int palindromicPartitioning(String s) {
    if (s == null) {
      return 0;
    }

    int n = s.length();
    populateDPDefaultValues(n, -1);

    return minPartitionsWithValidPalindrome(s, 0, n - 1);
  }

  private int minPartitionsWithValidPalindrome(String s, int i, int j) {

    if (i >= j) {
      return 0;
    }

    if (isPalindromic(s, i, j)) {
      return 0;
    }

    if (dp[i][j] != -1) {
      return dp[i][j];
    }

    int min = Integer.MAX_VALUE;

    for (int k = i; k < j; k++) {
      int temp = 1 + minPartitionsWithValidPalindrome(s, i, k)
          + minPartitionsWithValidPalindrome(s, k + 1, j);

      min = Math.min(min, temp);
    }

    dp[i][j] = min;
    return min;
  }

  public boolean isPalindromic(String s, int i, int j) {
    if (j - i < 1) {
      return true;
    }

    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }

    return true;
  }

  private int minCostToMultiply(int[] arr, int i, int j) {

    if (i >= j) {
      return 0;
    }

    if (dp[i][j] != -1) {
      return dp[i][j];
    }

    int min = Integer.MAX_VALUE;

    for (int k = i; k < j; k++) {
      int temp =
          minCostToMultiply(arr, i, k)
              + minCostToMultiply(arr, k + 1, j)
              + arr[i - 1] * arr[k] * arr[j];

      min = Math.min(min, temp);
    }

    dp[i][j] = min;
    return min;
  }


}
