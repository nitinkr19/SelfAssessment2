package test.java.practice.dynamicprogramming.mcm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import main.java.practice.dynamicprogramming.mcm.MCM;
import main.java.practice.dynamicprogramming.mcm.MatrixChainMultiplication;
import org.junit.jupiter.api.Test;

class MatrixChainMultiplicationTest {

  private final MCM mcm = new MatrixChainMultiplication();
  int[] arr = new int[]{40, 20, 30, 40, 30};

  @Test
  void minCostToMultiply() {
    assertEquals(72000, mcm.minCostToMultiply(arr));
  }

  @Test
  void palindromicPartitioning() {
    String s = "nitink";
    assertEquals(1, mcm.palindromicPartitioning(s.toLowerCase()));
    s = "nitinks";
    assertEquals(2, mcm.palindromicPartitioning(s.toLowerCase()));
    s = "";
    assertEquals(0, mcm.palindromicPartitioning(s.toLowerCase()));
    s = null;
    assertEquals(0, mcm.palindromicPartitioning(s));

  }

  @Test
  void isPalindromic() {
    MatrixChainMultiplication mcm1 = new MatrixChainMultiplication();
    String s = "nitin";
    assertTrue(mcm1.isPalindromic(s, 0, s.length() - 1));

    s = "nitink";
    assertTrue(mcm1.isPalindromic(s, 1, 3));
    assertFalse(mcm1.isPalindromic(s, 1, 4));
  }

  @Test
  void minCostToConnectSticks() {
    assertEquals(14, mcm.minCostToConnectSticks(new int[]{2, 4, 3}));
    assertEquals(30, mcm.minCostToConnectSticks(new int[]{1, 8, 3, 5}));
  }
}