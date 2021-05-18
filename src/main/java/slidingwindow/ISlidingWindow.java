package main.java.slidingwindow;

public interface ISlidingWindow {

  //Pattern1
  //array/string
  //Largest-Minimum
  //Sum
  //fixed-sliding window(k)
  //use : int/string

  int maxSumOfSubArrayOfSizeK(int[] a, int k);

  void printFirstNegativeInSubArrayOfSizeK(int[] a, int k);

  int countAnagrams(String s, String w);

  void printMaxInSubArrayOfSizeK(int[] a, int k);

  //Pattern2
  //array/string
  //Largest-Minimum
  //Sum
  //variable sliding window
  // use : map/list

  int longestSubstringWithKUniqueChars(String s, int k);

  int longestSubstringWithoutRepeatingChars(String s);


}
