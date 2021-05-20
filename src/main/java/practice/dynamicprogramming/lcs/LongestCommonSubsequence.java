package main.java.practice.dynamicprogramming.lcs;

public class LongestCommonSubsequence implements LCS {

  @Override
  public int lengthOfLCSRecursive(String s1, String s2) {
    return lcsRecursive(s1, s2, s1.length(), s2.length());
  }

  @Override
  public int lengthOfLcsDP(String s1, String s2) {

    int n = s1.length();
    int m = s2.length();

    int[][] dp = populateLcsDP(s1, s2, n, m);

    return dp[n][m];
  }

  private int[][] populateLcsDP(String s1, String s2, int n, int m) {
    int[][] dp = new int[n + 1][m + 1];

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(
              dp[i - 1][j],
              dp[i][j - 1]
          );
        }
      }
    }
    return dp;
  }

  @Override
  public int lengthOfLongestCommonSubstring(String s1, String s2) {

    int n = s1.length();
    int m = s2.length();

    int[][] dp = new int[n + 1][m + 1];

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        }
      }
    }

    int max = -1;

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = 0;
        }

        if (dp[i][j] > max) {
          max = dp[i][j];
        }
      }
    }

    return max;
  }

  @Override
  public String printLcs(String s1, String s2) {

    int n = s1.length();
    int m = s2.length();

    int[][] dp = populateLcsDP(s1, s2, n, m);

    int i = n, j = m;
    String lcs = "";

    while (i != 0 && j != 0) {

      if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

        lcs = s1.charAt(i - 1) + lcs;
        i = i - 1;
        j = j - 1;
      } else {

        if (dp[i - 1][j] > dp[i][j - 1]) {
          i = i - 1;
        } else {
          j = j - 1;
        }
      }
    }

    return lcs;
  }

  @Override
  public int lengthOfShortestSuperSequence(String s1, String s2) {
    int len = lengthOfLcsDP(s1, s2);

    return s1.length() + s2.length() - len;
  }

  @Override
  public int[] minInsertionDeletionConvertAToB(String s1, String s2) {
    int len = lengthOfLcsDP(s1, s2);

    return new int[]{s2.length() - len, s1.length() - len};
  }

  @Override
  public int lengthOfLongestPalindromicSubsequence(String s1) {

    String s2 = "";
    for (int i = 0; i < s1.length(); i++) {
      s2 = s1.charAt(i) + s2;
    }

    return lengthOfLcsDP(s1, s2);
  }

  @Override
  public int minDeletionToMakePalindrome(String s1) {

    int len = lengthOfLongestPalindromicSubsequence(s1);
    return s1.length() - len;
  }

  @Override
  public int minInsertionToMakePalindrome(String s1) {

    int len = lengthOfLongestPalindromicSubsequence(s1);
    return s1.length() - len;
  }

  @Override
  public String printShortestSuperSequence(String s1, String s2) {

    int n = s1.length();
    int m = s2.length();

    int[][] dp = populateLcsDP(s1, s2, n, m);

    int i = n, j = m;
    String scs = "";

    while (i != 0 && j != 0) {

      if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

        scs = s1.charAt(i - 1) + scs;
        i = i - 1;
        j = j - 1;
      } else {

        if (dp[i - 1][j] > dp[i][j - 1]) {
          scs = s1.charAt(i - 1) + scs;
          i = i - 1;
        } else {
          scs = s2.charAt(j - 1) + scs;
          j = j - 1;
        }
      }
    }

    while (i > 0) {
      scs = s1.charAt(i - 1) + scs;
      i--;
    }

    while (j > 0) {
      scs = s2.charAt(j - 1) + scs;
      j--;
    }

    return scs;
  }

  @Override
  public int longestRepeatingSubsequence(String s1) {
    String s2 = String.copyValueOf(s1.toCharArray());

    int n = s1.length();
    int m = s2.length();

    int[][] dp = new int[n + 1][m + 1];

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        }
      }
    }

    int max = -1;

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {

        if ((s1.charAt(i - 1) == s2.charAt(j - 1)) && (i != j)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(
              dp[i - 1][j],
              dp[i][j - 1]
          );
        }

        if (dp[i][j] > max) {
          max = dp[i][j];
        }
      }
    }

    return max;

  }

  @Override
  public boolean sequencePatternMatch(String pattern, String s) {

    int len = lengthOfLcsDP(pattern, s);
    return len == Math.min(pattern.length(), s.length());
  }

  private int lcsRecursive(String s1, String s2, int n, int m) {

    if (n == 0 || m == 0) {
      return 0;
    }

    if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
      return 1 + lcsRecursive(s1, s2, n - 1, m - 1);
    } else {
      return Math.max(
          lcsRecursive(s1, s2, n - 1, m),
          lcsRecursive(s1, s2, n, m - 1)
      );
    }

  }
}
