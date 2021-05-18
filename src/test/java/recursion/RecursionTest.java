package test.java.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import main.java.recursion.IRecur;
import main.java.recursion.Recursion;
import main.java.stack.Stack;
import org.junit.jupiter.api.Test;
import test.java.BaseSystemTest;
import test.java.BaseTreeTest;

class RecursionTest extends BaseSystemTest {

  private final IRecur recursion = new Recursion();
  private final BaseTreeTest baseTreeTest = new BaseTreeTest();

  @Test
  void printNToOne() {
    setUpStreams();
    recursion.printNToOne(8);
    assertEquals("8 7 6 5 4 3 2 1", outContent.toString());
  }

  @Test
  void printOneToN() {
    setUpStreams();
    recursion.printOneToN(8);
    assertEquals("1 2 3 4 5 6 7 8 ", outContent.toString());
  }

  @Test
  void factorial() {
    assertEquals(720, recursion.factorial(6));
  }

  @Test
  void nthFibonacci() {
    setUpStreams();
    assertEquals(8, recursion.nthFibonacci(6));
  }

  @Test
  void height() {
    assertEquals(4, recursion.height(baseTreeTest.node));
  }

  @Test
  void sortArray() {
    int[] a = new int[]{1, 5, 6, 7, 8, 3, 2};
    setUpStreams();
    recursion.sortArray(a);
    recursion.printArray(a, a.length);
    assertEquals("1 2 3 5 6 7 8 ", outContent.toString());
  }

  @Test
  void sortStack() {
    Stack<Integer> stack = populateStack();
    setUpStreams();
    recursion.sortStack(stack);
    stack.display();
    assertEquals("8 7 6 5 2 1 \n", outContent.toString());
  }

  private Stack<Integer> populateStack() {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(5);
    stack.push(6);
    stack.push(7);
    stack.push(8);
    stack.push(2);
    return stack;
  }

  @Test
  void deleteMiddleElementInStack() {
    Stack<Integer> stack = populateStack();
    setUpStreams();
    recursion.deleteMiddleElementInStack(stack);
    stack.display();
    assertEquals("2 8 6 5 1 \n", outContent.toString());
  }

  @Test
  void deleteMiddleElementInStack1() {
    Stack<Integer> stack = populateStack();
    setUpStreams();
    stack.push(9);
    recursion.deleteMiddleElementInStack(stack);
    stack.display();
    assertEquals("9 2 8 6 5 1 \n", outContent.toString());
  }

  @Test
  void towerOfHanoi() {
    assertEquals(7, recursion.towerOfHanoi(3));
    assertEquals(134, recursion.towerOfHanoi(7));
  }

  @Test
  void printArray() {
    int[] a = new int[]{1, 2, 3, 5, 6, 7, 8};
    setUpStreams();
    recursion.printArray(a, a.length);
    assertEquals("1 2 3 5 6 7 8 ", outContent.toString());
  }

  @Test
  void printSubsets() {
    setUpStreams();
    recursion.printSubsets("abc");
    assertEquals(" c b bc a ac ab abc ", outContent.toString());
    restoreStreams();
  }

  @Test
  void printSubsets1() {
    setUpStreams();
    recursion.printSubsets("nitin");
    assertEquals(
        " n i in t tn ti tin i in ii iin it itn iti itin n nn ni nin nt ntn nti ntin ni nin nii niin nit nitn niti nitin ",
        outContent.toString());
    restoreStreams();
  }

  @Test
  void printPermutationsWithSpaces() {

    setUpStreams();
    recursion.printPermutationsWithSpaces("abc");
    assertEquals("abc|ab c|a bc|a b c|", outContent.toString());
    restoreStreams();
  }

  @Test
  void printPermutationsWithCase() {

    setUpStreams();
    recursion.printPermutationsWithCase("ab");
    assertEquals("ab|aB|Ab|AB|", outContent.toString());
    restoreStreams();
  }

  @Test
  void printPermutationsWithCase1() {

    setUpStreams();
    recursion.printPermutationsWithCase("pair");
    assertEquals("pair|paiR|paIr|paIR|pAir|pAiR|pAIr|pAIR|Pair|PaiR|PaIr|PaIR|PAir|PAiR|PAIr|PAIR|",
        outContent.toString());
    restoreStreams();
  }

  @Test
  void printPermutationsWithDigits() {

    setUpStreams();
    recursion.printPermutationsWithDigits("a1b2");
    assertEquals("a1b2|a1B2|A1b2|A1B2|", outContent.toString());
    restoreStreams();
  }

  @Test
  void generateParenthesis() {
    setUpStreams();
    recursion.generateParenthesis(3);
    assertEquals("((()))|(()())|(())()|()(())|()()()|", outContent.toString());
    restoreStreams();
  }

  @Test
  void generatePrefixWithOneMoreThanZeroInBinary() {

    setUpStreams();
    recursion.generatePrefixWithOneMoreThanZeroInBinary(3);
    assertEquals("111|110|101|", outContent.toString());
    restoreStreams();
  }
}