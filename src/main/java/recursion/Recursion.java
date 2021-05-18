package main.java.recursion;

import java.util.ArrayList;
import java.util.List;
import main.java.stack.Stack;
import main.java.trees.Node;

public class Recursion implements IRecur {

  int count = 0;

  @Override
  public void printNToOne(int n) {

    //BC
    if (n == 1) {
      System.out.print(n);
      return;
    }

    //I
    System.out.print(n + " ");

    //H
    printNToOne(n - 1);
  }

  @Override
  public void printOneToN(int n) {

    //BC
    if (n == 1) {
      System.out.print(n + " ");
      return;
    }

    //H
    printOneToN(n - 1);

    //I
    System.out.print(n + " ");
  }

  @Override
  public void printArray(int[] a, int n) {

    //BC
    if (n == 1) {
      System.out.print(a[n - 1] + " ");
      return;
    }

    //H
    printArray(a, n - 1);

    //I
    System.out.print(a[n - 1] + " ");
  }

  @Override
  public int factorial(int n) {

    //BC
    if (n == 1) {
      return 1;
    }

    //H
    int temp = factorial(n - 1);

    //I
    temp = n * temp;
    return temp;
  }

  @Override
  public int nthFibonacci(int n) {

    //BC
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }

    //H
    int last = nthFibonacci(n - 1);
    int lastToLast = nthFibonacci(n - 2);

    //I
    return last + lastToLast;
  }

  @Override
  public int height(Node<Integer> root) {

    //BC
    if (root == null) {
      return 0;
    }

    //H
    int leftH = height(root.getLeft());
    int rightH = height(root.getRight());

    //I
    return 1 + Math.max(leftH, rightH);
  }

  @Override
  public void sortArray(int[] a) {
    sortArray(a, a.length);
  }

  public void sortArray(int[] a, int n) {

    //BC
    if (n == 1) {
      return;
    }

    int temp = a[n - 1];
    //H
    sortArray(a, n - 1);

    //I
    //insert a[size-1] at correct place
    insertAtOrderedPlace(a, temp, n - 1);
  }

  private void insertAtOrderedPlace(int[] a, int val, int n) {

    //BC
    if (n == 0 || val >= a[n - 1]) {
      a[n] = val;
      return;
    }

    int temp = a[n - 1];
    //H
    insertAtOrderedPlace(a, val, n - 1);

    //I
    a[n] = temp;
  }

  @Override
  public void sortStack(Stack<Integer> stack) {

    //BC
    if (stack.getSize() == 1) {
      return;
    }

    int temp = stack.pop();

    //H
    sortStack(stack);

    //I
    insertAtOrderedPlace(stack, temp);
  }

  @Override
  public void deleteMiddleElementInStack(Stack<Integer> stack) {
    deleteMiddleElement(stack, stack.getSize() / 2, stack.getSize());
  }

  @Override
  public int towerOfHanoi(int n) {

    int s = 1;
    int h = 2;
    int d = 3;

    towerOfHanoi(s, d, h, n);
    return count;
  }

  @Override
  public void printSubsets(String s) {

    String out = "";
    String in = s;
    List<String> list = new ArrayList<>();
    printSubsets(in, out, list);
  }

  @Override
  public void printPermutationsWithSpaces(String s) {

    String out = "";
    String in = s;
    List<String> list = new ArrayList<>();
    out = s.charAt(0) + "";
    in = s.substring(1);
    printPermutationsWithSpaces(in, out, list);
  }

  @Override
  public void printPermutationsWithCase(String s) {

    String out = "";
    String in = s.toLowerCase();
    List<String> list = new ArrayList<>();
    printPermutationsWithCase(in, out, list);
  }

  @Override
  public void printPermutationsWithDigits(String s) {

    String out = "";
    String in = s.toLowerCase();
    List<String> list = new ArrayList<>();
    printPermutationsWithDigits(in, out, list);
  }

  @Override
  public void generateParenthesis(int n) {

    String out = "";
    int open = n;
    int close = n;
    List<String> list = new ArrayList<>();
    generateParenthesis(out, open, close, list);
  }

  @Override
  public void generatePrefixWithOneMoreThanZeroInBinary(int n) {

    String out = "";
    int ones = 1;
    int zeroes = 0;
    List<String> list = new ArrayList<>();
    generatePrefixes(out + "1", ones, zeroes, n - 1, list);
  }

  private void generatePrefixes(String out, int ones, int zeroes, int n, List<String> list) {

    //BC
    if (n == 0) {
      System.out.print(out + "|");
      list.add(out);
      return;
    }

    //H+I
    if (ones > 0) {
      generatePrefixes(out + "1", ones + 1, zeroes, n - 1, list);
    }

    if (zeroes < ones) {
      generatePrefixes(out + "0", ones, zeroes + 1, n - 1, list);
    }

  }

  private void generateParenthesis(String out, int open, int close, List<String> list) {

    //BC
    if (open == 0 && close == 0) {
      System.out.print(out + "|");
      list.add(out);
      return;
    }

    //H+I
    if (open > 0) {
      generateParenthesis(out + "(", open - 1, close, list);
    }

    if (close > open) {
      generateParenthesis(out + ")", open, close - 1, list);
    }
  }

  private void printPermutationsWithDigits(String in, String out, List<String> list) {

    //BC
    if (in.length() == 0) {
      System.out.print(out + "|");
      list.add(out);
      return;
    }

    //H+I
    if ((in.charAt(0) >= 'a' && in.charAt(0) <= 'z')
        || (in.charAt(0) >= 'A' && in.charAt(0) <= 'Z')
    ) {
      printPermutationsWithDigits(in.substring(1), out + (in.charAt(0) + "").toLowerCase(), list);
      printPermutationsWithDigits(in.substring(1), out + (in.charAt(0) + "").toUpperCase(), list);
    } else {
      printPermutationsWithDigits(in.substring(1), out + in.charAt(0), list);
    }
  }

  private void printPermutationsWithCase(String in, String out, List<String> list) {

    //BC
    if (in.length() == 0) {
      System.out.print(out + "|");
      list.add(out);
      return;
    }

    //H+I
    printPermutationsWithCase(in.substring(1), out + (in.charAt(0) + "").toLowerCase(), list);
    printPermutationsWithCase(in.substring(1), out + (in.charAt(0) + "").toUpperCase(), list);

  }

  private void printPermutationsWithSpaces(String in, String out, List<String> list) {

    //BC
    if (in.length() == 0) {
      System.out.print(out + "|");
      list.add(out);
      return;
    }

    //H+I
    printPermutationsWithSpaces(in.substring(1), out + in.charAt(0), list);
    printPermutationsWithSpaces(in.substring(1), out + " " + in.charAt(0), list);
  }

  private void printSubsets(String in, String out, List<String> list) {

    //BC
    if (in.length() == 0) {
      System.out.print(out + " ");
      list.add(out);
      return;
    }

    //H+I
    printSubsets(in.substring(1), out, list);
    printSubsets(in.substring(1), out + in.charAt(0), list);
  }

  private void towerOfHanoi(int s, int d, int h, int n) {

    //BC
    if (n == 1) {
      count++;
      System.out.println("Step : " + count + " Moving " + n + " from " + s + " to " + d);
      return;
    }

    //H
    towerOfHanoi(s, h, d, n - 1);
    count++;
    System.out.println("Step : " + count + " Moving " + n + " from " + s + " to " + d);

    //I
    towerOfHanoi(h, d, s, n - 1);

  }

  private void deleteMiddleElement(Stack<Integer> stack, int index, int size) {

    //BC
    if (index == size) {
      return;
    }

    int temp = stack.pop();
    //H
    deleteMiddleElement(stack, index, size - 1);

    //I
    if (index != size - 1) {
      stack.push(temp);
    }
  }

  private void insertAtOrderedPlace(Stack<Integer> stack, int val) {

    //BC
    if (stack.getSize() == 0 || val >= stack.peek()) {
      stack.push(val);
      return;
    }

    int temp = stack.pop();
    //H
    insertAtOrderedPlace(stack, val);

    //I
    stack.push(temp);
  }
}
