package main.java.practice.games;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyFirstGame {

  public static final char BLANK_CHAR = '.';
  private static final char[] PLAYERS = {'R', 'B'};
  private static final int WINNING_COUNT = 4;

  private final int height, width;
  private final char[][] grid;
  private int lastCol = -1;
  private int lastRow = -1;

  public MyFirstGame(int h, int w) {
    this.height = h;
    this.width = w;
    this.grid = new char[h][w];

    for (int i = 0; i < h; i++) {
      grid[i] = new char[w];
      Arrays.fill(grid[i], BLANK_CHAR);
    }
  }

  public String toString() {
    return IntStream.range(0, width)
        .mapToObj(Integer::toString).collect(Collectors.joining())
        + "\n"
        + Arrays.stream(grid)
        .map(String::new)
        .collect(Collectors.joining("\n"));
  }

  public boolean isWinningPlay() {

    if (lastCol == -1) {
      return false;
    }

    char player = grid[lastRow][lastCol];

    StringBuilder plays = new StringBuilder();
    for (int i = 0; i < WINNING_COUNT; i++) {
      plays.append(player);
    }

    return
        contains(horizontal(), plays.toString())
            || contains(vertical(), plays.toString())
            || contains(diagonal(), plays.toString())
            || contains(revDiagonal(), plays.toString());

  }

  private String horizontal() {
    return new String(grid[lastRow]);
  }

  private String vertical() {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < height; i++) {
      s.append(grid[i][lastCol]);
    }
    return s.toString();
  }
  /*
     0 1 2 3 4
   0
   1 . R
   2
   3

   */

  private String diagonal() {
    StringBuilder s = new StringBuilder();
    for (int h = 0; h < height; h++) {
      int w = lastCol + lastRow - h;

      if (w >= 0 && w < width) {
        s.append(grid[h][w]);
      }
    }
    return s.toString();
  }

  private String revDiagonal() {
    StringBuilder s = new StringBuilder();
    for (int h = 0; h < height; h++) {
      int w = lastCol - lastRow + h;

      if (w >= 0 && w < width) {
        s.append(grid[h][w]);
      }
    }
    return s.toString();
  }

  private boolean contains(String s, String pattern) {
    return s.contains(pattern);
  }

  public void playTurn(int player, int playTurn) {

    if (!(playTurn >= 0 && playTurn <= width)) {
      System.out.println("Invalid move!");
      return;
    }

    for (int h = height - 1; h >= 0; h--) {
      if (grid[h][playTurn] == BLANK_CHAR) {
        grid[h][playTurn] = PLAYERS[player];
        lastRow = h;
        lastCol = playTurn;
        return;
      }
    }

    System.out.println("Column : " + playTurn + " is full!");
  }

  public void run(int[] playTurns) {

    int moves = height * width;

    System.out.println("Valid Moves : 0-" + (width - 1) + " to choose a col");
    System.out.println(this);

    int turn = 0;
    for (int player = 0; moves-- >= 0; player = 1 - player) {

      if (turn < playTurns.length) {
        playTurn(player, playTurns[turn++]);
        System.out.println(this);

        if (isWinningPlay()) {
          System.out.println(PLAYERS[player] + " wins!!!");
          return;
        }
      }

    }

    System.out.println("Game over, no winner, pls try again!");
  }


}
