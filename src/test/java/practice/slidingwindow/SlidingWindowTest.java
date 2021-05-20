package test.java.practice.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import main.java.practice.slidingwindow.ISlidingWindow;
import main.java.practice.slidingwindow.SlidingWindow;
import org.junit.jupiter.api.Test;
import test.java.practice.BaseSystemTest;

class SlidingWindowTest extends BaseSystemTest {

  private final ISlidingWindow slidingWindow = new SlidingWindow();
  int k = 2;
  int[] arr = new int[]{2, 3, 7, 8, 10};
  int[] intArr = new int[]{12, 4, -5, -7, 10, -8, 3, 1, 2, -7};

  @Test
  void maxSumOfSubArrayOfSizeK() {
    assertEquals(18, slidingWindow.maxSumOfSubArrayOfSizeK(arr, k));
    assertEquals(25, slidingWindow.maxSumOfSubArrayOfSizeK(arr, 3));
  }

  @Test
  void printFirstNegativeInSubArrayOfSizeK() {
    setUpStreams();
    slidingWindow.printFirstNegativeInSubArrayOfSizeK(intArr, 3);
    assertEquals("-5 -5 -5 -7 -8 -8 0 -7 ", outContent.toString());
    restoreStreams();
  }

  @Test
  void countAnagrams() {
    String s = "foraxcofrolorfofor";
    String w = "for";
    assertEquals(6, slidingWindow.countAnagrams(s, w));

  }

  @Test
  void printMaxInSubArrayOfSizeK() {
    setUpStreams();
    int[] intArr = new int[]{12, 4, 7, -5, -7, 10, -8, 3, 1, 2, -7};
    slidingWindow.printMaxInSubArrayOfSizeK(intArr, 3);
    assertEquals("12 7 7 10 10 10 3 3 2 ", outContent.toString());
    restoreStreams();
  }

  @Test
  void longestSubstringWithKUniqueChars() {
    assertEquals(7, slidingWindow.longestSubstringWithKUniqueChars("aabacbebebe", 3));
    assertEquals(4, slidingWindow.longestSubstringWithKUniqueChars("aaaa", 1));
  }

  @Test
  void longestSubstringWithoutRepeatingChars() {
    assertEquals(4, slidingWindow.longestSubstringWithoutRepeatingChars("aabacbebebe"));
    assertEquals(3, slidingWindow.longestSubstringWithoutRepeatingChars("pwwkew"));
  }
}