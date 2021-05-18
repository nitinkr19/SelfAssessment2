package main.java.recursion;

import main.java.stack.Stack;
import main.java.trees.Node;

public interface IRecur {

  void printNToOne(int n);

  void printOneToN(int n);

  void printArray(int[] a, int n);

  int factorial(int n);

  int nthFibonacci(int n);

  int height(Node<Integer> node);

  void sortArray(int[] a);

  void sortStack(Stack<Integer> stack);

  void deleteMiddleElementInStack(Stack<Integer> stack);

  int towerOfHanoi(int n);

  void printSubsets(String s);

  void printPermutationsWithSpaces(String s);

  void printPermutationsWithCase(String s);

  void printPermutationsWithDigits(String s);

  void generateParenthesis(int n);

  void generatePrefixWithOneMoreThanZeroInBinary(int n);

}
