package main.java.practice.arrays;

public class Splitwise {

  public void settleTransactions(int[][] transactions) {

    int[] amount = calculateAmount(transactions);

    settleAmounts(amount);
  }

  private void settleAmounts(int[] amounts) {

    int maxDebitP = getMinP(amounts);
    int maxCreditP = getMaxP(amounts);

    int maxDebit = amounts[maxDebitP];
    int maxCredit = amounts[maxCreditP];

    if (maxDebit == 0 && maxCredit == 0) {
      return;
    }

    int min = Math.min(maxCredit, -maxDebit);
    maxCredit -= min;
    maxDebit += min;

    System.out.println("P" + maxDebitP + "->P" + maxCreditP + " : " + min);

    amounts[maxDebitP] = maxDebit;
    amounts[maxCreditP] = maxCredit;

    settleAmounts(amounts);
  }

  private int getMinP(int[] amounts) {
    int minInd = 0;
    for (int i = 1; i < amounts.length; i++) {
      if (amounts[i] < amounts[minInd]) {
        minInd = i;
      }
    }
    return minInd;
  }

  private int getMaxP(int[] amounts) {
    int maxInd = 0;
    for (int i = 1; i < amounts.length; i++) {
      if (amounts[i] > amounts[maxInd]) {
        maxInd = i;
      }
    }
    return maxInd;
  }

  private int[] calculateAmount(int[][] transactions) {

    int size = transactions.length;
    int[] amounts = new int[size];

    for (int p = 0; p < size; p++) {
      for (int i = 0; i < size; i++) {
        amounts[p] += transactions[i][p] - transactions[p][i];
      }
    }

    return amounts;
  }

}
