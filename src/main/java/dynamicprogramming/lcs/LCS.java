package main.java.dynamicprogramming.lcs;

public interface LCS {

  int lengthOfLCSRecursive(String s1, String s2);

  int lengthOfLcsDP(String s1, String s2);

  int lengthOfLongestCommonSubstring(String s1, String s2);

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
