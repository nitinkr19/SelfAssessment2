package main.java.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stocks {

  public int maxProfit(int[] prices) {

    int max = Integer.MIN_VALUE;
    int minPrice = Integer.MAX_VALUE;

    for (int i = 1; i < prices.length; i++) {
      minPrice = Math.min(prices[i - 1], minPrice);
      max = Math.max(max, prices[i] - minPrice);
    }

    return max;
  }

  public int maxProfitWithMultipleTransactions(int[] prices) {

    int minPrice = Integer.MAX_VALUE;
    int result = 0;

    for (int i = 1; i < prices.length; i++) {
      minPrice = Math.min(prices[i - 1], minPrice);

      if (prices[i] > prices[i - 1]) {
        result = result + (prices[i] - prices[i - 1]);
      } else {
        minPrice = prices[i];
      }

    }

    return result;
  }

  //not working yet
  public int maxProfitWithKTransactions(int[] prices, int k) {

    int minPrice = Integer.MAX_VALUE;
    int result = 0;
    int localMax = 0;
    List<Integer> localMaxList = new ArrayList<>();

    for (int i = 1; i < prices.length; i++) {
      minPrice = Math.min(prices[i - 1], minPrice);

      if (prices[i] > prices[i - 1]) {
        localMax = localMax + (prices[i] - prices[i - 1]);
      } else {
        minPrice = prices[i];
        localMaxList.add(localMax);
        localMax = 0;
      }
    }

    localMaxList.sort(Collections.reverseOrder());

    return localMaxList.get(0) + localMaxList.get(1);
  }

}
