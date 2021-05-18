package main.java.dynamicprogramming.knapsack.unbounded;

public interface IKnapsackU {

  int rodCutting(int[] len, int[] price, int N, int n);

  int coinChangeMaxWays(int[] coin, int sum, int n);

  int coinChangeMinCoins(int[] coin, int sum, int n);

}
