package test.java.practice.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import main.java.practice.arrays.Stocks;
import org.junit.jupiter.api.Test;

class StocksTest {

  Stocks stocks = new Stocks();
  int[] prices = new int[]{7, 1, 5, 3, 6, 4};

  @Test
  void maxProfit() {
    assertEquals(5, stocks.maxProfit(prices));
  }

  @Test
  void maxProfitWithMultipleTransactions() {
    assertEquals(7, stocks.maxProfitWithMultipleTransactions(prices));
    prices = new int[]{7, 1, 5, 3, 6, 7};
    assertEquals(8, stocks.maxProfitWithMultipleTransactions(prices));
  }

  @Test
  void maxProfitWithKTransactions() {
    prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
    assertEquals(6, stocks.maxProfitWithKTransactions(prices, 2));
    prices = new int[]{7, 1, 5, 3, 6, 7};
    assertEquals(8, stocks.maxProfitWithKTransactions(prices, 2));
  }

  @Test
  void maxProfitWithKTransactionsV0() {
    prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
    assertEquals(6, stocks.maxProfitWithKTransactionsV0(prices, 2));
    prices = new int[]{7, 1, 5, 3, 6, 7};
    assertEquals(8, stocks.maxProfitWithKTransactionsV0(prices, 2));
  }
}