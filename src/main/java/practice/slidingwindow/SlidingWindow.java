package main.java.practice.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SlidingWindow implements ISlidingWindow {

  @Override
  public int maxSumOfSubArrayOfSizeK(int[] a, int k) {

    int sum = 0;
    int res = Integer.MIN_VALUE;
    int n = a.length;

    for (int i = 0, j = 0; j < n; ) {

      sum = sum + a[j];
      if (j - i + 1 < k) {
        j++;
      } else {
        if (sum > res) {
          res = sum;
        }
        sum = sum - a[i];
        i++;
        j++;
      }

    }

    return res;
  }

  @Override
  public void printFirstNegativeInSubArrayOfSizeK(int[] a, int k) {

    List<Integer> list = new ArrayList<>();
    int n = a.length;

    for (int i = 0, j = 0; j < n; ) {

      if (a[j] < 0) {
        list.add(a[j]);
      }

      if (j - i + 1 < k) {
        j++;
      } else {

        int firstLocalNegative = !list.isEmpty() ? list.get(0) : 0;
        System.out.print(firstLocalNegative + " ");
        if (!list.isEmpty() && a[i] == list.get(0)) {
          list.remove(0);
        }
        i++;
        j++;
      }
    }

  }

  @Override
  public int countAnagrams(String s, String w) {

    int n = s.length();
    int k = w.length();
    int count = 0;
    HashMap<Character, Integer> map = new HashMap<>();
    int disCount = 0;

    for (int i = 0; i < k; i++) {
      char c = w.charAt(i);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        disCount++;
        map.put(c, 1);
      }
    }

    for (int i = 0, j = 0; j < n; ) {

      char c = s.charAt(j);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) - 1);
        if (map.get(c) == 0) {
          disCount--;
        }
      }

      if (j - i + 1 < k) {
        j++;
      } else {

        if (disCount == 0) {
          count++;
        }

        char ithChar = s.charAt(i);
        if (map.containsKey(ithChar)) {
          map.put(ithChar, map.get(ithChar) + 1);
          if (map.get(ithChar) == 1) {
            disCount++;
          }
        }

        i++;
        j++;
      }
    }
    return count;
  }

  @Override
  public void printMaxInSubArrayOfSizeK(int[] a, int k) {

    List<Integer> list = new ArrayList<>();
    int n = a.length;

    for (int i = 0, j = 0; j < n; ) {

      if (!list.isEmpty()) {
        int l = 0;
        List<Integer> newList = new ArrayList<>();
        while (l < list.size()) {
          if (list.get(l) > a[j]) {
            newList.add(list.get(l));
          }
          l++;
        }
        list = newList;
      }
      list.add(a[j]);

      if (j - i + 1 < k) {
        j++;
      } else {

        int localMax = !list.isEmpty() ? list.get(0) : 0;
        System.out.print(localMax + " ");
        if (!list.isEmpty() && a[i] == list.get(0)) {
          list.remove(0);
        }
        i++;
        j++;
      }
    }

  }

  @Override
  public int longestSubstringWithKUniqueChars(String s, int k) {

    int n = s.length();
    int res = 0;
    HashMap<Character, Integer> map = new HashMap<>();

    for (int i = 0, j = 0; j < n; ) {
      char charJ = s.charAt(j);
      map.put(charJ, map.getOrDefault(charJ, 0) + 1);

      if (map.keySet().size() < k) {

        j++;
      } else if (map.keySet().size() == k) {

        if (j - i + 1 > res) {
          res = j - i + 1;
        }
        j++;

      } else {

        char c;
        while (map.keySet().size() > k) {
          c = s.charAt(i);
          map.put(c, map.get(c) - 1);
          if (map.get(c) == 0) {
            map.remove(c);
          }
          i++;
        }

        j++;
      }

    }

    return res;
  }

  @Override
  public int longestSubstringWithoutRepeatingChars(String s) {

    int n = s.length();
    int repeatChar = 0;
    int res = 0;

    int k = 0;
    HashMap<Character, Integer> map = new HashMap<>();

    for (int i = 0, j = 0; j < n; ) {
      char charJ = s.charAt(j);
      map.put(charJ, map.getOrDefault(charJ, 0) + 1);

      if (map.get(charJ) > 1) {
        repeatChar++;
      }

      if (repeatChar < k) {

        j++;
      } else if (repeatChar == k) {

        if (j - i + 1 > res) {
          res = j - i + 1;
        }
        j++;

      } else {

        char c;
        while (map.get(charJ) > 1) {
          c = s.charAt(i);
          map.put(c, map.get(c) - 1);
          if (map.get(c) == 1) {
            repeatChar--;
          }
          i++;
        }

        j++;
      }

    }

    return res;
  }

}
