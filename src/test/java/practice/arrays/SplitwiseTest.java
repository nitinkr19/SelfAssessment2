package test.java.practice.arrays;

import main.java.practice.arrays.Splitwise;
import org.junit.jupiter.api.Test;

class SplitwiseTest {

  Splitwise splitwise = new Splitwise();

  @Test
  void settleTransactions() {
    int[][] t = new int[][]
        {
            {0, 1000, 2000},
            {0, 0, 5000},
            {0, 0, 0}
        };
    splitwise.settleTransactions(t);
  }
}