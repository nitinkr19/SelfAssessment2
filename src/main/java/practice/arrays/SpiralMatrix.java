package main.java.practice.arrays;

public class SpiralMatrix {

  public static void main(String[] args) {
    int n = 8;
    int[][] matrix = generateSpiralMatrix(n);
    for (int r = 0; r < n; r++) {

      for (int c = 0; c < n; c++) {
        System.out.print((matrix[r][c] < 10 ? "0" : "") + matrix[r][c] + " ");
      }
      System.out.println();
    }
  }

  private static int[][] generateSpiralMatrix(int n) {
    int[][] matrix = new int[n][n];

    int[] dr = new int[]{0, 1, 0, -1};
    int[] dc = new int[]{1, 0, -1, 0};

    int dir = 0;
    int r = 0;
    int c = 0;
    int val = 0;
    int limit = n * n;

    if (n <= 0) {
      throw new IllegalArgumentException("n > 0");
    }

    while (val++ < limit) {
      matrix[r][c] = val;
      r += dr[dir];
      c += dc[dir];

      if (isInvalid(matrix, r, c)) {
        r -= dr[dir];
        c -= dc[dir];
        dir = (dir + 1) % 4;
        r += dr[dir];
        c += dc[dir];
      }
    }

    return matrix;

  }

  private static boolean isInvalid(int[][] matrix, int r, int c) {
    return r < 0 || c < 0 || r >= matrix.length || c >= matrix.length || matrix[r][c] != 0;
  }

}