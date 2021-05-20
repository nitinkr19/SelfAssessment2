package main.java.practice.arrays;

import java.util.ArrayList;
import java.util.List;

public class LookAndSay {

  public static void main(String[] args) {
    int n = 10;
    lookAndSayUsingString(n);
    System.out.println("Done");
  }

  //read list
  //count same numbers till different
  //store count in new list with that number
  //count next numbers till the size of list
  private static void lookAndSay(int n) {

    int lines = 0;
    int index = 0;
    int currentCount = 1;
    int currentNumber;
    int previousNumber;
    List<Integer> list = new ArrayList<Integer>();
    List<Integer> newList;
    list.add(1);

    while (lines < n) {

      printList(list);
      index = 0;
      previousNumber = 0;
      newList = new ArrayList<Integer>();
      while (index < list.size()) {
        currentNumber = list.get(index);
        if (currentNumber == previousNumber) {
          currentCount += 1;
        }

        if (previousNumber != 0 && currentNumber != previousNumber) {
          newList.add(currentCount);
          newList.add(previousNumber);
          currentCount = 1;
        }

        previousNumber = currentNumber;
        index++;
      }

      if (index == list.size()) {
        newList.add(currentCount);
        newList.add(previousNumber);
        currentCount = 1;
      }
      list = newList;
      lines++;
    }
  }

  private static void printList(List<Integer> list) {
    for (Integer integer : list) {
      System.out.print(integer);
    }
    System.out.println();
  }

  //read list
  //count same numbers till different
  //store count in new list with that number
  //count next numbers till the size of list
  private static void lookAndSayUsingString(int n) {

    String output = "1";
    for (int index = 1; index <= n; index++) {
      System.out.println(output);
      output = lookAndSay(output);
    }

  }

  private static String lookAndSay(String str) {

    if (str.length() == 1) {
      return "1" + str;
    }

    String output = "";
    char cur = str.charAt(0);
    int count = 1;
    for (int i = 1; i <= str.length(); i++) {
      if (i == str.length() || cur != str.charAt(i)) {
        output += count + String.valueOf(Integer.parseInt(String.valueOf(cur)));
        count = 1;
        if (i != str.length()) {
          cur = str.charAt(i);
        }
      } else {
        count++;
      }
    }
    return output;
  }
}

