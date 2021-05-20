package main.java.practice.dynamicprogramming.lcs;

public interface LCS {

  int lengthOfLCSRecursive(String s1, String s2);

  int lengthOfLcsDP(String s1, String s2);

  int lengthOfLongestCommonSubstring(String s1, String s2);

  /*
    {10, 22, 9, 33, 21, 50, 41, 60, 80}
    10 -> 22 -> 33 -> 50 -> 60 -> 80
    6
   */
  int lengthOfLongestIncreasingSubsequence(int[] arr);

  String printLcs(String s1, String s2);

  int lengthOfShortestSuperSequence(String s1, String s2);

  int[] minInsertionDeletionConvertAToB(String s1, String s2);

  int lengthOfLongestPalindromicSubsequence(String s);

  int minDeletionToMakePalindrome(String s);

  int minInsertionToMakePalindrome(String s);

  String printShortestSuperSequence(String s1, String s2);

  int longestRepeatingSubsequence(String s);

  boolean sequencePatternMatch(String pattern, String s);

}
