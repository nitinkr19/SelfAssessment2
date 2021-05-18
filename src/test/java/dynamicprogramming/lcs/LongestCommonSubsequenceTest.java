package test.java.dynamicprogramming.lcs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import main.java.dynamicprogramming.lcs.LCS;
import main.java.dynamicprogramming.lcs.LongestCommonSubsequence;
import org.junit.jupiter.api.Test;

class LongestCommonSubsequenceTest {

  private final LCS lcs = new LongestCommonSubsequence();

  String s1 = "Nitin";
  String s2 = "Ntini";

  @Test
  void lengthOfLCSRecursive() {
    assertEquals(4, lcs.lengthOfLCSRecursive(s1, s2));
  }

  @Test
  void lengthOfLcsDP() {
    assertEquals(4, lcs.lengthOfLcsDP(s1, s2));
  }

  @Test
  void lengthOfLongestCommonSubstring() {
    assertEquals(3, lcs.lengthOfLongestCommonSubstring(s1, s2));
  }

  @Test
  void printLcs() {
    assertEquals("Ntin", lcs.printLcs(s1, s2));
  }

  @Test
  void lengthOfShortestSuperSequence() {
    assertEquals(6, lcs.lengthOfShortestSuperSequence(s1, s2));
  }

  @Test
  void minInsertionDeletionConvertAToB() {
    int[] arr = lcs.minInsertionDeletionConvertAToB(s1, s2);
    assertEquals(1, arr[0]);
    assertEquals(1, arr[1]);
  }

  @Test
  void lengthOfLongestPalindromicSubsequence() {
    assertEquals(5, lcs.lengthOfLongestPalindromicSubsequence(s1.toLowerCase()));
    assertEquals(3, lcs.lengthOfLongestPalindromicSubsequence(s2.toLowerCase()));
  }

  @Test
  void minDeletionToMakePalindrome() {
    assertEquals(0, lcs.minDeletionToMakePalindrome(s1.toLowerCase()));
    assertEquals(2, lcs.minDeletionToMakePalindrome(s2.toLowerCase()));
  }

  @Test
  void printShortestSuperSequence() {
    assertEquals("Nitini", lcs.printShortestSuperSequence(s1, s2));
    s1 = "Nitin";
    s2 = "TiKnumar";
    assertEquals("nitiknumar", lcs.printShortestSuperSequence(s1.toLowerCase(), s2.toLowerCase()));
  }

  @Test
  void longestRepeatingSubsequence() {
    assertEquals(1, lcs.longestRepeatingSubsequence(s1.toLowerCase()));
    s1 = "AABCBEDD";
    assertEquals(3, lcs.longestRepeatingSubsequence(s1.toLowerCase()));
  }

  @Test
  void sequencePatternMatch() {

    s1 = "abc";
    s2 = "anbghbnc";
    assertTrue(lcs.sequencePatternMatch(s1.toLowerCase(), s2.toLowerCase()));

    s1 = "abc";
    s2 = "anghnc";
    assertFalse(lcs.sequencePatternMatch(s1.toLowerCase(), s2.toLowerCase()));

  }

  @Test
  void minInsertionToMakePalindrome() {
    s1 = "ini";
    assertEquals(0, lcs.minInsertionToMakePalindrome(s1.toLowerCase()));
    s2 = "ABCDBA";
    assertEquals(1, lcs.minInsertionToMakePalindrome(s2.toLowerCase()));
  }
}